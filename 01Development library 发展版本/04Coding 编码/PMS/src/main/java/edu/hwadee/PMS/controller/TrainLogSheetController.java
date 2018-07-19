package edu.hwadee.PMS.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import edu.hwadee.PMS.entity.TrainLogSheet;
import edu.hwadee.PMS.entity.TrainPlan;
import edu.hwadee.PMS.service.TrainLogSheetService;

@RestController
@RequestMapping("/TAM")
public class TrainLogSheetController extends BaseController{

	/**
	 * 通过培训计划明细编号获得培训计划明细
	 * @param id
	 * @return
	 */
	@GetMapping(value="/trainlogsheet/{id}",produces="application/json;charset=utf-8")
	public String getTrainLogSheet(@PathVariable("id") Integer id) {
		Map<String, Object> json = new HashMap<String, Object>();
		TrainLogSheet sheet = trainLogSheetService.getTrainLogSheet(id);
		
		json.put("data", JSON.toJSON(sheet));
		return JSON.toJSONString(json);
	}
	
	/**
	 * 通过培训计划编号获得培训计划明细
	 * @param id
	 * @return
	 */
	@GetMapping(value="/trainlogsheet",produces="application/json;charset=utf-8")
	public String getTrainLogSheetByAssessment(@RequestParam("assessment") Integer id) {
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("code", 200);
		TrainPlan trainPlan = trainPlanService.getTrainPlanByAssessment(id);
		TrainLogSheet sheet = trainLogSheetService.getTrainLogSheetByTrainPlan(trainPlan);
		
		json.put("data", JSON.toJSON(sheet));
		return JSON.toJSONString(json);
	}
	
}
