package com.dev.efficiency.repository;

import com.dev.efficiency.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findBypId(String loginId);

	boolean existsByProjectCode(String projectCode);
}
