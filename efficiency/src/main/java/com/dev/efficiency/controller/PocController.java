package com.dev.efficiency.controller;

import com.dev.efficiency.entity.Dsr;
import com.dev.efficiency.repository.DsrRepo;
import com.dev.efficiency.repository.UserRepository;
import com.dev.efficiency.service.impl.DsrServiceImpl;
import com.dev.efficiency.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/poc")
public class PocController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DsrRepo dsrRepo;
	@Autowired
	DsrServiceImpl dsrServiceImpl;
	
	@Autowired
	UserServiceImpl  userServiceImpl;
	
	


	@PostMapping("/login")
	public Object login(@RequestParam String loginId) {
		
		return userServiceImpl.login(loginId);
		

	}
	
	@PostMapping("/addDsr")
	public Dsr addDsr(@RequestBody Dsr dsr) {
		
		return dsrServiceImpl.addDsr(dsr);
		
		
	}

	
	@DeleteMapping("/delDsr")
	public Object deleteDSR(@RequestBody Map<Object, Object> payload) {
		
		 dsrServiceImpl.deleteDSR(payload);
		
		
		Map<String, String> m = new HashMap<>(); 
		m.put("message", "Record Deleted Succesfully");
		return m;
	}
	
	@PutMapping("/updateDsr")
	public Object updateDsr(@RequestBody Dsr dsr) {
		
		return dsrServiceImpl.updateDsr(dsr);
		
	}
	
	@GetMapping("/getDsr")
	public List<Dsr> getDsrBySpringname(@RequestParam String sprintName) {

		return dsrServiceImpl.getDsrBySpringname(sprintName);
		
	}
	
	@GetMapping("/getAllDsrByDeveloper")
	public Object getAllDsrByDeveloper(@RequestParam String pid) {
		return dsrServiceImpl.getAllDsrByDeveloper(pid);
	}
	
	
	@GetMapping("/getAllDSRDateForAdmin")
	public Object getAllDSRDateForAdmin() {
		
		return dsrServiceImpl.getAllDSRDateForAdmin();
	}
	
}
