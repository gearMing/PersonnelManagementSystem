package edu.hwadee.PMS.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.hwadee.PMS.repository.QImfoRepository;
import edu.hwadee.PMS.repository.TrainLogSheetRepository;
import edu.hwadee.PMS.repository.TrainPlanRepository;
import edu.hwadee.PMS.repository.TrainResultRepository;

public class BaseService {

	@Autowired
	protected QImfoRepository qir;
	
	@Autowired
	protected TrainLogSheetRepository tlr;
	
	@Autowired
	protected TrainPlanRepository tpr;
	
	@Autowired
	protected TrainResultRepository trr;
}
