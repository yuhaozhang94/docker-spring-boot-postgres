package com.platform.cloud.xpmanagement.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*
* @author Zhang Yuhao <yuhao.zhang94@gmail.com>
* Created on: 7/9/2020
*/
@Entity
@Table(name = "experience_log")
public class ExperienceLog {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int experience_log_id;
	
	private int experience_id; // get from experience
	private int player_id; // get from experience
	private int amount; // get from POST 
	
	@Enumerated(EnumType.ORDINAL)
	private Type xp_type; // derive from amount
	
	private String remarks; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at_timestamp;
	
	public ExperienceLog() {
		
	}

	public ExperienceLog(int experience_id, int player_id, int amount, Type xp_type,
			String remarks) {
		this.experience_id = experience_id;
		this.player_id = player_id;
		this.amount = amount;
		this.xp_type = xp_type;
		this.remarks = remarks;
		this.created_at_timestamp = new Date();
	}

	public int getExperience_log_id() {
		return experience_log_id;
	}

	public void setExperience_log_id(int experience_log_id) {
		this.experience_log_id = experience_log_id;
	}

	public int getExperience_id() {
		return experience_id;
	}

	public void setExperience_id(int experience_id) {
		this.experience_id = experience_id;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Type getXp_type() {
		return xp_type;
	}

	public void setXp_type(Type xp_type) {
		this.xp_type = xp_type;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreated_at_timestamp() {
		return created_at_timestamp;
	}

	public void setCreated_at_timestamp(Date created_at_timestamp) {
		this.created_at_timestamp = created_at_timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((created_at_timestamp == null) ? 0 : created_at_timestamp.hashCode());
		result = prime * result + experience_id;
		result = prime * result + experience_log_id;
		result = prime * result + player_id;
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((xp_type == null) ? 0 : xp_type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExperienceLog other = (ExperienceLog) obj;
		if (amount != other.amount)
			return false;
		if (created_at_timestamp == null) {
			if (other.created_at_timestamp != null)
				return false;
		} else if (!created_at_timestamp.equals(other.created_at_timestamp))
			return false;
		if (experience_id != other.experience_id)
			return false;
		if (experience_log_id != other.experience_log_id)
			return false;
		if (player_id != other.player_id)
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (xp_type != other.xp_type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Experience_Log [experience_log_id=" + experience_log_id + ", experience_id=" + experience_id
				+ ", player_id=" + player_id + ", amount=" + amount + ", xp_type=" + xp_type + ", remarks=" + remarks
				+ ", created_at_timestamp=" + created_at_timestamp + "]";
	}
	
}
