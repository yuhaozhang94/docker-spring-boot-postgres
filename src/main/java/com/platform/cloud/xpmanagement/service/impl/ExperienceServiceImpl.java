package com.platform.cloud.xpmanagement.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.cloud.xpmanagement.entity.Experience;
import com.platform.cloud.xpmanagement.entity.ExperienceLog;
import com.platform.cloud.xpmanagement.repo.ExperienceRepo;
import com.platform.cloud.xpmanagement.repo.ExperienceLogRepo;
import com.platform.cloud.xpmanagement.service.ExperienceService;

/**
*
* @author Zhang Yuhao <yuhao.zhang94@gmail.com>
* Created on: 7/9/2020
*/
@Service
public class ExperienceServiceImpl implements ExperienceService
{

	@Autowired
	private ExperienceRepo expRepo;
	
	@Autowired
	private ExperienceLogRepo expLogRepo;

	@Override
	public Experience createExperience(Experience xp)
	{
		return expRepo.save(xp);
	}

	@Override
	public void updateExperience(Experience xp)
	{
		expRepo.save(xp);
	}
	
	@Override
	public Experience getExperience(int id)
	{
		Optional<Experience> optional = expRepo.findByPlayerId(id);
		Experience xp = optional.get();
		return xp;
	}


	@Override
	public boolean isExperienceExist(int player_id)
	{
		return expRepo.existsByPlayerId(player_id);
	}
	
	
	@Override
	public ExperienceLog createExperienceLog(ExperienceLog expLog) 
	{
		return expLogRepo.save(expLog);
	}
	
}
