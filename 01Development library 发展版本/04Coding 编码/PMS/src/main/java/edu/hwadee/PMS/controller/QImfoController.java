package edu.hwadee.PMS.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import edu.hwadee.PMS.entity.QImfo;
import edu.hwadee.PMS.service.QImfoService;

@RestController
@RequestMapping("/QI")
public class QImfoController extends BaseController{
	
	@GetMapping(value="/QImfo/{questionnaireId}",produces="application/json;charset=utf-8")
	public String getQImfo(@PathVariable("questionnaireId") Integer questionnaireId) {
		Map<String, Object> json = new HashMap<String, Object>();
		
		QImfo sheet = QImfoService.getQImfo(questionnaireId);
		
		json.put("data", JSON.toJSON(sheet));
		
		return JSON.toJSONString(json);
	}
}
