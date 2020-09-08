package com.platform.cloud.xpmanagement.service;

import com.platform.cloud.xpmanagement.entity.Experience;
import com.platform.cloud.xpmanagement.entity.ExperienceLog;

/**
*
* @author Zhang Yuhao <yuhao.zhang94@gmail.com>
* Created on: 7/9/2020
*/
public interface ExperienceService {
	
	public abstract Experience createExperience(Experience xp);
	
	public abstract void updateExperience(Experience xp);
	
	public abstract Experience getExperience(int player_id);
	
	public abstract boolean isExperienceExist(int player_id);
	
	public abstract ExperienceLog createExperienceLog(ExperienceLog xpLog);

}
