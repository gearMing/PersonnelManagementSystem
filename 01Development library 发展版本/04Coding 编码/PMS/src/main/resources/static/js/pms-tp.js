var if_firsttime = true;

<!-- 初始化页面参数 -->
$(document).ready(function() {
	$.data(document.body,"page",0);
	$.data(document.body,"size",10);
	$.data(document.body,"sort","assessment");
	$.data(document.body,"totalCounts",0);
//	$.data(document.body, "totalPages", 0);
	getPlan();

})


function getPlan() {
	// 获取页面参数
	var page = $.data(document.body,"page");
	var size = $.data(document.body,"size");
	var sort = $.data(document.body,"sort");
	$.ajax({
		type: "GET",
		url: "/TPM/tps",
		data: {
			page: page,
			size: size,
			sort: sort,
		},
		dataType: "json",
		success: function(res) {
			if(res.code == 200) {
				refreshTable(res.data);
				
			} else {
				
			}
		},
		error: function(res) {
			alert(res.msg);
		}
	});
}



<!-- 刷新Table数据 -->
function refreshTable(data) {
	var html = "";
	$('#table-data').empty();
	data.content.forEach(function(item) {
		html += "<tr><td><input type='checkbox' /></td><td>" + item.assessment + "</td><td>" + item.planName + "</td><td>" + item.budget + "</td><td><button onclick='openChangeModal(this)'>修改计划</button><button onclick='openDelModal(this)'>删除计划</button><button onclick='openLogSheetModal(this)'>管理培训台账</button><button>管理培训计划</button></td></tr>"; 
	});
	$('#table-data').html(html);
	// 更新总记录数
	$.data(document.body,"totalCounts",data.totalElements);
	
	if(if_firsttime) {
		if_firsttime = false;
		$('#pagination').jqPaginator({
			totalCounts: $.data(document.body,"totalCounts"),
			pageSize: $.data(document.body, "size"),
			visiblePages: 10,
			currentPage: $.data(document.body,"page")+1,
			wrapper: "<ul></ul>",
			first: '<li class="first"><a href="javascript:void(0);">首页</a></li>', 
	        prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',	
	        next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',		
	        last: '<li class="last"><a href="javascript:void(0);">末页</a></li>',	
	        page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
			onPageChange: function PageChange(page_index, type) {
				$.data(document.body,"page",page_index-1);
				getPlan();
			}
		});
	} else {
		$('#pagination').jqPaginator('option',{
			totalCounts: $.data(document.body,"totalCounts")
//			pageSize: $.data(document.body, "size")
		});
	}

}

//function pageselectCallback(page_index, jq) {
//	$.data(document.body,"page",page_index);
//	getPlan();
//	return false;
//}

<!-- 打开修改计划模态框 -->
function openChangeModal(ele) {
	$('#change_plan_id').val($(ele).parent().parent().children("td").eq(1).text());
	$('#change_plan_name').val($(ele).parent().parent().children("td").eq(2).text());
	$('#change_plan_budget').val($(ele).parent().parent().children("td").eq(3).text());
	$('#modal-plan-change').modal('show');
}

<!-- 发送修改请求 -->
function changePlan() {
	var assessment = $('#change_plan_id').val();
	var planName = $('#change_plan_name').val();
	var budget = $('#change_plan_budget').val();
	$.ajax({
		type: "PUT",
		url: "/TPM",
		data: {
			assessment: assessment,
			planName: planName,
			budget: budget
		},
		dataType: "json",
		success: function(res) {
			if(res.code==200) {
				getPlan();
			}
		},
		error: function() {
			alert("修改失败，服务器出错");
		}
	});
	$('#modal-plan-change').modal('hide');
	
}

<!-- 打开删除计划模态框 -->
function openDelModal(ele) {
	var plan_id = $(ele).parent().parent().children("td").eq(1).text();
	var plan_name = $(ele).parent().parent().children("td").eq(2).text();
	$('#del_plan_id').text(plan_id);
	$('#del_plan_name').text(plan_name);
	$('#modal-plan-del').modal('show');
}
<!-- 删除培训计划 -->
function delPlan() {
	var plan_id = $('#del_plan_id').text();
	$.ajax({
		type: "DELETE",
		url: "/TPM/"+plan_id,
		dataType: "json",
		success: function(res) {
			if(res.code==200) {
				getPlan();
			} else {
				alert("删除计划失败");
			}
		},
		error: function() {
			alert("删除计划失败，服务器出错");
		}
	});
	$('#modal-plan-del').modal('hide');
}

<!-- 打开管理培训台账模态框 -->
function openLogSheetModal(ele) {
	var plan_id = $(ele).parent().parent().children("td").eq(1).text();
	$.ajax({
		type: "GET",
		url: "/TAM/trainlogsheet?assessment="+plan_id,
		dataType: "json",
		success: function(res) {
			if(res.code==200) {
				$('#logsheet_id').val(res.data.id);
				$('#assessment').val(res.data.trainPlan.assessment);
				$('#worker_id').val(res.data.trainStaff.id.traWorkerId);
				$('#worker_name').val(res.data.trainStaff.id.traWorkerName);
				$('#category').val(res.data.traingingCategory);
				$('#training').val(res.data.training);
				$('#people_num').val(res.data.numberPeople);
				$('#time').val(res.data.time);
				$('#purpose').val(res.data.purpose);
				$('#object').val(res.data.object);
				$('#sponsor').val(res.data.sponsor);
				$('#area').val(res.data.trainingArea);
				$('#remark').val(res.data.remark);
				
			} else if(res.code==404){
				// 无培训明细表
				alert(res.msg);
			} else {
				alert(res.msg);
			}
		},
		error: function() {
			alert("服务器出错，获取培训台账失败");
		}
	});
	$('#modal-logsheet-manage').modal('show');
}

function saveLogSheet() {
	$('#logsheet_id').val(res.data.id);
	$('#assessment').val(res.data.trainPlan.assessment);
	$('#worker_id').val(res.data.trainStaff.id.traWorkerId);
	$('#worker_name').val(res.data.train.Staff.id.traWorkerName);
	$('#category').val(res.data.trainingCategory);
	$('#training').val(res.data.training);
	$('#pepople_num').val(res.data.numberPeople);
	$('#time').val(res.data.time);
	$('#purpose').val(res.data.purpose);
	$('#object').val(res.data.object);
	$('#sponsor').val(res.data.sponsor);
	$('#area').val(res.data.trainingArea);
	$('#remark').val(res.data.remark);
	$.ajax({
		type: "PUT",
		url: "/TAM/trainlogsheet",
		data: {
			
		},
		dataType: "json",
		success: function(res) {
			
		},
		error: function() {
			alert("服务器出错，无法保存修改");
		}
	});
}