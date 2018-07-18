package edu.hwadee.PMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hwadee.PMS.entity.TrainPlan;
import edu.hwadee.PMS.entity.TrainResult;
import edu.hwadee.PMS.repository.TrainResultRepository;

@Service
@Transactional
public class TrainResultService extends BaseService{

	public void addTrainResult(TrainResult result) {
		trr.save(result);
	}

	public void addTrainResults(List<TrainResult> results) {
		trr.save(results);
	}

	public TrainResult getTrainResultByTrainPlan(TrainPlan trainPlan) {
		return trr.findByTrainPlan(trainPlan);
	}

	public TrainResult getTrainResultByResult(String reult) {
		return trr.findByReult(reult);
	}

	public TrainResult getTrainResultByTrainingResultId(Integer trainingResultId) {
		return trr.findOne(trainingResultId);
	}

	public List<TrainResult> getTrainResultByIdList(List<Integer> idlist) {
		return trr.findAll(idlist);
	}

	public List<TrainResult> getAllTrainResults() {
		return trr.findAll();
	}

	public void updateTrainResult(TrainResult result) {
		trr.save(result);
	}

	public void updateTrainResults(List<TrainResult> results) {
		trr.save(results);
	}

	public void deleteTrainResultByTrainingResultId(int id) {
		trr.delete(id);
	}

	public void deleteTrainResult(TrainResult result) {
		trr.delete(result);
	}

	public void deleteTrainResults(List<TrainResult> results) {
		trr.delete(results);
	}

	public void ClearTrainResults() {
		trr.deleteAll();
	}

}
