package com.dev.efficiency.service.impl;

import com.dev.efficiency.dto.LoginResponse;
import com.dev.efficiency.entity.User;
import com.dev.efficiency.repository.DsrRepo;
import com.dev.efficiency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DsrRepo dsrRepo;

	public Object login(String loginId) {
		User user = userRepository.findBypId(loginId);
		LoginResponse loginResponse = new LoginResponse();

		if (user == null) {
			Map<String, String> m = new HashMap<>(); 
			m.put("message", "Record not found for given pid " +loginId);
			return m;

		} else {
			if (user.getProjectCode() != null) {

				loginResponse.setMessage("Login Succesful");
				loginResponse.setRole("Admin");
				loginResponse.setPid(user.getpId());
				loginResponse.setName(user.getName());

				return loginResponse;

			} else {
				loginResponse.setMessage("Login Succesful");
				loginResponse.setRole("Developer");
				loginResponse.setPid(user.getpId());
				loginResponse.setName(user.getName());

				return loginResponse;

			}
		}
	}

}
