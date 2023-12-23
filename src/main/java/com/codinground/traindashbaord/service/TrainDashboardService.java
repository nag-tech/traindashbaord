package com.codinground.traindashbaord.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.codinground.traindashbaord.dao.TrainDashbaordDao;
import com.codinground.traindashbaord.dto.TrainDetails;

@Service
public class TrainDashboardService {

	private static final Logger logger = LoggerFactory.getLogger(TrainDashboardService.class);

	private final TrainDashbaordDao trainDashbaordDao;

	public TrainDashboardService(TrainDashbaordDao trainDashbaordDao) {
		this.trainDashbaordDao = trainDashbaordDao;
	}

	public List<TrainDetails> getAllTrains() {
		return trainDashbaordDao.findAll();
	}

	public TrainDetails addOrUpdateTrainDetails(TrainDetails trainDetails) {
		return trainDashbaordDao.save(trainDetails);
	}

	public void deleteTrain(Long trainId) {
		trainDashbaordDao.deleteById(trainId);
	}
}
