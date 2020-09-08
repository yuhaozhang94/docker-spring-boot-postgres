package com.platform.cloud.xpmanagement.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "experience")
public class Experience {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int experience_id;
	
	private int player_id; // to be given by REST call
	private int balance = 0; // default is 0
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at_timestamp;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at_timestamp;
	
	public Experience() {
		
	}
	
	// Create a new Experience given player_id
	public Experience(int player_id) {
		this.player_id = player_id;
		this.created_at_timestamp = new Date(); // now
		this.updated_at_timestamp = new Date(); // now
	}
	
	// Create a new Experience given player_id and initial points
		public Experience(int player_id, int points) {
			this.player_id = player_id;
			this.balance = points;
			this.created_at_timestamp = new Date(); // now
			this.updated_at_timestamp = new Date(); // now
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
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Date getCreated_at_timestamp() {
		return created_at_timestamp;
	}
	public void setCreated_at_timestamp(Date created_at_timestamp) {
		this.created_at_timestamp = created_at_timestamp;
	}
	public Date getUpdated_at_timestamp() {
		return updated_at_timestamp;
	}
	public void setUpdated_at_timestamp(Date updated_at_timestamp) {
		this.updated_at_timestamp = updated_at_timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + ((created_at_timestamp == null) ? 0 : created_at_timestamp.hashCode());
		result = prime * result + experience_id;
		result = prime * result + player_id;
		result = prime * result + ((updated_at_timestamp == null) ? 0 : updated_at_timestamp.hashCode());
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
		Experience other = (Experience) obj;
		if (balance != other.balance)
			return false;
		if (created_at_timestamp == null) {
			if (other.created_at_timestamp != null)
				return false;
		} else if (!created_at_timestamp.equals(other.created_at_timestamp))
			return false;
		if (experience_id != other.experience_id)
			return false;
		if (player_id != other.player_id)
			return false;
		if (updated_at_timestamp == null) {
			if (other.updated_at_timestamp != null)
				return false;
		} else if (!updated_at_timestamp.equals(other.updated_at_timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Experience [experience_id=" + experience_id + ", player_id=" + player_id + ", balance=" + balance
				+ ", created_at_timestamp=" + created_at_timestamp + ", updated_at_timestamp=" + updated_at_timestamp
				+ "]";
	}
	
}
