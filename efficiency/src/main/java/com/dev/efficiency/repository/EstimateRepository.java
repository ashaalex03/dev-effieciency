package com.dev.efficiency.repository;

import com.dev.efficiency.entity.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstimateRepository extends JpaRepository<Estimate,Long> {

    Optional<Object> findByJiraId(int jiraId);

    List<Estimate> findAllBySprintNameAndStatus(String sprintName, String active);
}
