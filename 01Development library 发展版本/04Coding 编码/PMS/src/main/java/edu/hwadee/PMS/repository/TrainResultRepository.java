package edu.hwadee.PMS.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hwadee.PMS.entity.TrainPlan;
import edu.hwadee.PMS.entity.TrainResult;

@Transactional
public interface TrainResultRepository extends JpaRepository<TrainResult, Integer>{

	public TrainResult findByTrainPlan(TrainPlan trainPlan);
	public TrainResult findByReult(String reult);
	public void deleteByTrainPlan(TrainPlan trainPlan);
}
