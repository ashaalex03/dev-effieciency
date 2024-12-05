package com.dev.efficiency.repository;

import com.dev.efficiency.entity.Dsr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DsrRepo extends JpaRepository<Dsr, Long> {

	void deleteByDsrId(Long dsrId);

	List<Dsr>  findBySprintName(String sprintName);

	Dsr findByDsrId(Long dsrId);

	List<Dsr> findAllByName(String name);
	
	

}
