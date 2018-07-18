package edu.hwadee.PMS.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hwadee.PMS.entity.TrainLogSheet;
import edu.hwadee.PMS.entity.TrainPlan;
import edu.hwadee.PMS.repository.TrainLogSheetRepository;

@Service
@Transactional
public class TrainLogSheetService extends BaseService {

	public TrainLogSheet getTrainLogSheet(Integer id) {
		return tlr.findOne(id);
	}
	
	public TrainLogSheet getTrainLogSheetByTrainPlan(TrainPlan trainPlan) {
		return tlr.findOneByTrainPlan(trainPlan);
	}
}