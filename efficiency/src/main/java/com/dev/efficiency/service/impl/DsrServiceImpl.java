package com.dev.efficiency.service.impl;

import com.dev.efficiency.dto.DeveloperListDto;
import com.dev.efficiency.entity.Dsr;
import com.dev.efficiency.entity.User;
import com.dev.efficiency.repository.DsrRepo;
import com.dev.efficiency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DsrServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DsrRepo dsrRepo;

	public Object getAllDsrByDeveloper(String pid) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("message", "Records not found for given Pid " + pid);
		
		User user = userRepository.findBypId(pid);
		
		if(user != null && user.getProjectCode() == null) {
			List<Dsr> dsrList = dsrRepo.findAllByName(user.getName());
			
			List<DeveloperListDto> developerListDtos = new ArrayList<>();
			
			for(Dsr dsr : dsrList)
			{
				
				DeveloperListDto developerListDto = new DeveloperListDto();
				developerListDto.setJiraId(dsr.getJiraId());
				developerListDto.setJiraDescription(dsr.getJiraDescription());
				developerListDto.setDevCompletition(dsr.getDevCompletition());
				developerListDto.setEstimatedHours(dsr.getEstimatedHours());
				developerListDto.setHoursSpent(dsr.getHoursSpent());
				developerListDto.setRemainingHours(dsr.getRemainingHours());
				developerListDto.setRemarks(dsr.getRemarks());
				
				developerListDtos.add(developerListDto);

			}
			
			
			return developerListDtos;

		}
		return hashMap;
	}

	public Dsr addDsr(Dsr dsr) {
		dsr.setDeleted("N");
		dsr.setReason(" ");

		Dsr dsr2 =   dsrRepo.save(dsr);
		return dsr2;
	}

	public void deleteDSR(Map<Object, Object> payload) {
		Dsr dsr = dsrRepo.findByDsrId(Long.valueOf(payload.get("dsrId").toString()));
		dsr.setDeleted("Y");
		
		String s = dsr.getReason() +" , "+ String.valueOf(payload.get("reason"));
		dsr.setReason(s);
		
		dsrRepo.save(dsr);
	}

	public Object updateDsr(Dsr dsr) {
		Dsr d = dsrRepo.findByDsrId(dsr.getDsrId());
		String s = d.getReason() +" , "+ dsr.getReason();
		dsr.setReason(s);
		
		
		Dsr res = null;
		if(d != null) {
			dsr.setDeleted("N");

			res = dsrRepo.save(dsr);

		}
		
		
		
		
		return res;
	}

	public List<Dsr> getDsrBySpringname(String sprintName) {
		List<Dsr> dsrList = dsrRepo.findBySprintName(sprintName);
		return dsrList;
	}

	public Object getAllDSRDateForAdmin() {
		return userRepository.findAll();
	}

}
