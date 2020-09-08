package com.platform.cloud.xpmanagement.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platform.cloud.xpmanagement.entity.Experience;

/**
*
* @author Zhang Yuhao <yuhao.zhang94@gmail.com>
* Created on: 7/9/2020
*/
public interface ExperienceRepo extends CrudRepository<Experience, Integer>
{
	@Query("select case when count(t)> 0 then true else false end from Experience t where t.player_id = :player_id")
	boolean existsByPlayerId(@Param("player_id") int player_id);
	
	@Query("SELECT t FROM Experience t where t.player_id = :player_id") 
	Optional<Experience> findByPlayerId(@Param("player_id") int player_id);
	
}
