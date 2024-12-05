package com.dev.efficiency.repository;

import com.dev.efficiency.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SprintRepository extends JpaRepository<Sprint,Long> {
    List<Sprint> findAllByProjectCode(String projectCode);

    List<Sprint> findAllByProjectCodeAndDeleted(String projectCode, String deleted);
}
