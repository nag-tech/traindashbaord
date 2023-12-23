package com.codinground.traindashbaord.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codinground.traindashbaord.dto.TrainDetails;

@Repository
public interface TrainDashbaordDao extends JpaRepository<TrainDetails, Long>{

}
