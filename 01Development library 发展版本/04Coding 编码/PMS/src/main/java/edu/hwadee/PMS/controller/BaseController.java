package edu.hwadee.PMS.controller;

import org.springframework.beans.factory.annotation.Autowired;

import edu.hwadee.PMS.service.QImfoService;
import edu.hwadee.PMS.service.TrainLogSheetService;
import edu.hwadee.PMS.service.TrainPlanService;
import edu.hwadee.PMS.service.TrainResultService;

public class BaseController {

	@Autowired
	protected QImfoService QImfoService;
	
	@Autowired
	protected TrainLogSheetService trainLogSheetService;
	
	@Autowired
	protected TrainPlanService trainPlanService;
	
	@Autowired
	protected TrainResultService trainResultService;
}
