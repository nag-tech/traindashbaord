package com.codinground.traindashbaord.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codinground.traindashbaord.dto.TrainDetails;
import com.codinground.traindashbaord.service.TrainDashboardService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(originPatterns = {"http://localhost:3000"})
public class TrainDashBoardController {

	private static final Logger logger = LoggerFactory.getLogger(TrainDashBoardController.class);

	private final TrainDashboardService trainDashboardService;

	public TrainDashBoardController(TrainDashboardService trainDashboardService) {
		this.trainDashboardService = trainDashboardService;
	}

	@GetMapping("/getAllTrains")
	public ResponseEntity<List<TrainDetails>> getAllTrains() {
		logger.info("Fetching the all train details");
		try {
			List<TrainDetails> trains = trainDashboardService.getAllTrains();
			return ResponseEntity.ok(trains);
		} catch (Exception e) {
			logger.error("Exception occured while fetching the train details {}",e.getMessage());
			return ResponseEntity.internalServerError().body(null);
		}

	}
	
	@CrossOrigin
	@PostMapping({"/addTrain", "/updateTrain"})
	public ResponseEntity<TrainDetails> addOrUpdateTrain(@RequestBody TrainDetails train) {
		logger.info("adding/updating the train details"+train);
		try {
			train = trainDashboardService.addOrUpdateTrainDetails(train);
			return ResponseEntity.ok(train);
		} catch (Exception e) {
			logger.error("Exception occured while adding/updating the train details {}",e.getMessage());
			return ResponseEntity.internalServerError().body(train);
		}

	}
	
	@DeleteMapping("/deleteTrain/{id}")
	public ResponseEntity<Boolean> deleteTrain(@PathVariable("id")Long trainId){
		logger.info("delete the train details of id {}", trainId);
		try {
			trainDashboardService.deleteTrain(trainId);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			logger.error("Exception occured while adding/updating the train details {}",e.getMessage());
			return ResponseEntity.internalServerError().body(false);
		}
	}

}
