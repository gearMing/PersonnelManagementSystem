package edu.hwadee.PMS.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hwadee.PMS.entity.TrainLogSheet;
import edu.hwadee.PMS.entity.TrainPlan;

@Transactional
public interface TrainLogSheetRepository extends JpaRepository<TrainLogSheet, Integer> {
	
	public void deleteByTrainPlan(TrainPlan trainPlan);
	public TrainLogSheet findOneByTrainPlan(TrainPlan trainPlan);
}
