package edu.hwadee.PMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import edu.hwadee.PMS.entity.TrainPlan;

public interface TrainPlanRepository extends JpaRepository<TrainPlan, Integer>{
	
	public TrainPlan findByplanName(String planName);
	public TrainPlan findBybudget(Integer budget);
}
