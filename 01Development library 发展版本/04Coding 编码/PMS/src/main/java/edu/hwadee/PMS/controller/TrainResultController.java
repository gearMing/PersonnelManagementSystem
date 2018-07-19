package edu.hwadee.PMS.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import edu.hwadee.PMS.entity.TrainPlan;
import edu.hwadee.PMS.entity.TrainResult;
import edu.hwadee.PMS.service.TrainResultService;

@RestController
public class TrainResultController extends BaseController{
	
	@PostMapping(value="/TRM/add")
	public void addTrainResult(TrainResult result){
		trainResultService.addTrainResult(result);
	}
	
	@GetMapping(value="/TRM/find/trainingResultId")
	public String getTrainResultByid(@RequestParam(name="trainingResultId")Integer id){
		TrainResult result = trainResultService.getTrainResultByTrainingResultId(id);
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("data", JSON.toJSON(result));
		return JSON.toJSONString(json);
	}
	
	@GetMapping(value="/TRM/find/trainPlan")
	public String getTrainResultBytrainPlan(@RequestParam(name="trainPlan")TrainPlan trainPlan){
		TrainResult result = trainResultService.getTrainResultByTrainPlan(trainPlan);
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("data", JSON.toJSON(result));
		return JSON.toJSONString(json);
	}
	
	@GetMapping(value="/TRM/find/reult")
	public String getTrainResultByreult(@RequestParam(name="reult")String reult){
		TrainResult result = trainResultService.getTrainResultByResult(reult);
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("data", JSON.toJSON(result));
		return JSON.toJSONString(json);
	}
	
	
	@PostMapping(value="/TRM/update")
	public void updateTrainResult(TrainResult result){
		trainResultService.updateTrainResult(result);
	}
	
	
	@DeleteMapping(value="/TRM/delete/id")
	public void deleteTrainResult(@RequestParam(name="trainingResultId") Integer id){
		trainResultService.deleteTrainResultByTrainingResultId(id);
	}
	
	@DeleteMapping(value="/TRM/delete")
	public void deleteTrainResult(TrainResult result){
		trainResultService.deleteTrainResult(result);
	}
}
