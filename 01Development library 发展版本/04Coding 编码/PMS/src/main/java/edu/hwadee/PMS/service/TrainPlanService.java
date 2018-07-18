package edu.hwadee.PMS.service;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import edu.hwadee.PMS.entity.TrainPlan;
import edu.hwadee.PMS.repository.TrainPlanRepository;

@Service
@Transactional
public class TrainPlanService extends BaseService {

	public TrainPlan getTrainPlanByPlanName(String planName) {
		return tpr.findByplanName(planName);
	}

	public TrainPlan getTrainPlanByBudget(Integer budget) {
		return tpr.findBybudget(budget);
	}

	public TrainPlan getTrainPlanByAssessment(Integer id) {
		return tpr.findOne(id);
	}

	public List<TrainPlan> getTrainPlanByIdList(List<Integer> idlist) {
		return tpr.findAll(idlist);
	}

	public List<TrainPlan> getAllTrainPlans() {
		return tpr.findAll();
	}

	public void updateTrainPlan(TrainPlan plan) {
		tpr.save(plan);
	}

	public void updateTrainPlans(List<TrainPlan> plan) {
		tpr.save(plan);
	}

	public void deleteTrainPlanByAssessment(int id) {
		TrainPlan plan = tpr.findOne(id);
		trr.deleteByTrainPlan(plan);
		tlr.deleteByTrainPlan(plan);
		tpr.delete(id);
	}

	public void deleteTrainPlan(TrainPlan plan) {
		trr.deleteByTrainPlan(plan);
		tlr.deleteByTrainPlan(plan);
		tpr.delete(plan);
	}

	public void deleteTrainPlans(List<TrainPlan> plans) {
		tpr.delete(plans);
	}

	public void ClearTrainPlans() {
		tpr.deleteAll();
	}

	public Page<TrainPlan> getTPsByPage(Pageable pageable) {
		return tpr.findAll(pageable);
	}
}
