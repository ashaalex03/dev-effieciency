package com.dev.efficiency.controller;

import com.dev.efficiency.dto.ApiResponse;
import com.dev.efficiency.dto.SprintDTO;
import com.dev.efficiency.entity.Sprint;
import com.dev.efficiency.exception.ResourceNotFoundException;
import com.dev.efficiency.mapper.SprintMapper;
import com.dev.efficiency.service.SprintService;
import com.dev.efficiency.util.EfficiencyConstant;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(EfficiencyConstant.BASE_URL)
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @Autowired
    private SprintMapper sprintMapper;

    @PostMapping("/createSprint")
    public ResponseEntity<ApiResponse> createSprint(@RequestBody @Valid SprintDTO sprintDTO) throws ResourceNotFoundException {
        Sprint sprintEntity = SprintMapper.toSprint(sprintDTO);
        Sprint newSprintEntity = sprintService.createSprint(sprintEntity);
        sprintDTO = SprintMapper.toSprintDTO(newSprintEntity);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Successfully Inserted the sprint detail");
        apiResponse.setData(sprintDTO);
        apiResponse.setStatus("Success");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/getAllSprintDetails/{projectCode}")
    public ResponseEntity<ApiResponse> getAllSprintDetails(@PathVariable("projectCode") String projectCode) throws ResourceNotFoundException {
        List<Sprint> sprintDetails = sprintService.getSprintDetails(projectCode);
        List<SprintDTO> sprintDTOList = SprintMapper.toSprintDTOList(sprintDetails);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Successfully fetched all sprint details");
        apiResponse.setData(sprintDTOList);
        apiResponse.setStatus("Success");
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping("/updateSprintBySprintId")
    public ResponseEntity<ApiResponse> updateSprint(@RequestBody @Valid SprintDTO sprintDTO) throws ResourceNotFoundException {
        Sprint sprintEntity = SprintMapper.toSprint(sprintDTO);
        Sprint newSprintEntity = sprintService.updateSprint(sprintEntity);
        sprintDTO = SprintMapper.toSprintDTO(newSprintEntity);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Sprint Details are updated successfully");
        apiResponse.setData(sprintDTO);
        apiResponse.setStatus("Success");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);
    }


    @DeleteMapping("/deleteSprintBySprintId/{id}/{reason}")
    public ResponseEntity<ApiResponse> deleteSprint(
            @PathVariable("id") long id, @PathVariable("reason") String reason) throws ResourceNotFoundException {
        sprintService.deleteSprint(id,reason);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Sprint Detail got deleted successfully");
        apiResponse.setData(Collections.emptyList());
        apiResponse.setStatus("Success");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);
    }

}
