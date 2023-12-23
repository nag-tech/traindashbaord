package com.codinground.traindashbaord.dto;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train_details")
public class TrainDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "train_route_id")
	private long trainRouteId;
	
	@Column(name = "train_num")
	private String trainNum;
	
	@Column(name = "train_name")
	private String trainName;
	
	@Column(name = "arrives_at")
	private LocalDateTime arrivesAt;
	
	@Column(name = "departs_at")
	private LocalDateTime departsAt;
	
	@Column(name = "platform_num")
	private int platform;

	public String getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public LocalDateTime getArrivesAt() {
		return arrivesAt;
	}

	public void setArrivesAt(LocalDateTime arrivesAt) {
		this.arrivesAt = arrivesAt;
	}

	public LocalDateTime getDepartsAt() {
		return departsAt;
	}

	public void setDepartsAt(LocalDateTime departsAt) {
		this.departsAt = departsAt;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

	public long getTrainRouteId() {
		return trainRouteId;
	}

	@Override
	public String toString() {
		return "TrainDetails [trainRouteId=" + trainRouteId + ", trainNum=" + trainNum + ", trainName=" + trainName
				+ ", arrivesAt=" + arrivesAt + ", departsAt=" + departsAt + ", platform=" + platform + "]";
	}
}
