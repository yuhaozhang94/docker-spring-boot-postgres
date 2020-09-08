package com.platform.cloud.xpmanagement.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.platform.cloud.xpmanagement.entity.Experience;
import com.platform.cloud.xpmanagement.entity.Type;
import com.platform.cloud.xpmanagement.entity.ExperienceLog;
import com.platform.cloud.xpmanagement.entity.Points;
import com.platform.cloud.xpmanagement.service.ExperienceService;

/**
*
* @author Zhang Yuhao <yuhao.zhang94@gmail.com>
* Created on: 7/9/2020
*/
@RestController
public class ExperienceServiceController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceServiceController.class);
	
	@Autowired
	private ExperienceService expService;

	// GET an experience by player_id
	@RequestMapping(value = "/experience/{player_id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getExperience(@PathVariable("player_id") int player_id)
	{
		LOGGER.info("Getting a experience with PLAYER_ID: {}", player_id);
		boolean isExperienceExist = expService.isExperienceExist(player_id);
		
		if (isExperienceExist)
		{
			LOGGER.info("The experience exists in DB.");
			Experience exp = expService.getExperience(player_id);
			return new ResponseEntity<>(exp, HttpStatus.OK);
		}
		else
		{
			LOGGER.info("The experience does not exist in DB.");
			// Create a new experience if it does not already exist
			LOGGER.info("Creating a new experience.");
			Experience exp = new Experience(player_id);
			exp = expService.createExperience(exp);
			return new ResponseEntity<>(exp, HttpStatus.OK);
		}

	}
	
	// POST an update to experience with player_id and points
	@RequestMapping(value = "/experience/{player_id}", method = RequestMethod.POST)
	public ResponseEntity<Object> updateExperience(@PathVariable("player_id") int player_id,
			@RequestBody Points requestBody)
	{
		int points = requestBody.getPoints();
		LOGGER.info("Updating a experience with PLAYER_ID: {} and points: {}", player_id, points);
		boolean isExperienceExist = expService.isExperienceExist(player_id);
		Experience exp;
		if (isExperienceExist)
		{
			LOGGER.info("The experience exists in DB.");
			exp = expService.getExperience(player_id);		
			// Update balance
			exp.setBalance(exp.getBalance() + points);
			exp.setUpdated_at_timestamp(new Date());	
			expService.updateExperience(exp);
		}
		else
		{
			LOGGER.info("The experience does not exist in DB.");
			// Create a new experience if it does not already exist
			LOGGER.info("Creating a new experience.");
			exp = new Experience(player_id, points);
			exp = expService.createExperience(exp);
		}
		
		LOGGER.info("Creating an experience log...");
		Type type = (points>0)?Type.EARN:Type.PENALTY;
		ExperienceLog log = new ExperienceLog(exp.getExperience_id(), exp.getPlayer_id(), points, type, "");		
		expService.createExperienceLog(log);
		
		return new ResponseEntity<>("Experience is updated successsfully", HttpStatus.OK);
	}
}
