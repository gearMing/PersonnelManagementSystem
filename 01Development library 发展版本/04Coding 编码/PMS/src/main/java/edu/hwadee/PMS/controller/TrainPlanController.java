package edu.hwadee.PMS.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import edu.hwadee.PMS.entity.TrainPlan;
import edu.hwadee.PMS.service.TrainPlanService;
import javassist.expr.NewArray;

@RestController
public class TrainPlanController extends BaseController {

	

	// 模糊搜索
	@GetMapping(value = "/TPM/assessment",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getTrainPlanByid(@RequestParam(name = "assessment") Integer id) {
		TrainPlan plan = trainPlanService.getTrainPlanByAssessment(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", plan);
		map.put("code", 200);
		return JSON.toJSONString(map);
	}

	@GetMapping(value = "/TPM/budget",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getTrainPlanBybudget(@RequestParam(name = "budget") Integer bg) {
		TrainPlan plan = trainPlanService.getTrainPlanByBudget(bg);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", plan);
		map.put("code", 200);
		return JSON.toJSONString(map);
	}

	@GetMapping(value = "/TPM/planName",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getTrainPlanByname(@RequestParam(name = "planName") String name) {
		TrainPlan plan = trainPlanService.getTrainPlanByPlanName(name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", plan);
		map.put("code", 200);
		return JSON.toJSONString(map);
	}

	@PutMapping(value = "/TPM",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateTrainPlan(TrainPlan plan) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("code", 200);
		System.out.println("update");
		trainPlanService.updateTrainPlan(plan);
		
		return JSON.toJSONString(res);
		
	}

	@DeleteMapping(value = "/TPM/{assessment}",produces="application/json;charset=utf-8")
	@ResponseBody
	public String deleteTrainPlan(@PathVariable("assessment") Integer id) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("code", 200);
		
		trainPlanService.deleteTrainPlanByAssessment(id);
		
		return JSON.toJSONString(res);
	}
	
	@GetMapping(value="/TPM/tps",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getTPsByPage(Pageable pageable) {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("code", 200);
		System.out.println(pageable);
		Page<TrainPlan> tps = trainPlanService.getTPsByPage(pageable);
		
		res.put("data", tps);
		
		return JSON.toJSONString(res);
	}
}
