package com.dev.efficiency.controller;

import com.dev.efficiency.dto.ApiResponse;
import com.dev.efficiency.dto.EstimateDTO;
import com.dev.efficiency.entity.Estimate;

import com.dev.efficiency.exception.ResourceNotFoundException;
import com.dev.efficiency.mapper.EstimateMapper;
import com.dev.efficiency.service.EstimateService;
import com.dev.efficiency.util.EfficiencyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping(EfficiencyConstant.BASE_URL)
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @PostMapping(EfficiencyConstant.CREATE_ESTIMATE)
    public ResponseEntity<ApiResponse> createEstimate(@RequestBody EstimateDTO estimateDTO) {
        Estimate estimateEntity = EstimateMapper.toEntity(estimateDTO);
        Estimate newEstimateEntity = estimateService.createEstimate(estimateEntity);
        estimateDTO = EstimateMapper.toDTO(newEstimateEntity);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Successfully Inserted the Estimate detail");
        apiResponse.setData(estimateDTO);
        apiResponse.setStatus("Success");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


    @GetMapping("/getAllSprintEstimate/{sprintName}")
    public ResponseEntity<ApiResponse> getAllSprintEstimate(@PathVariable String sprintName) throws ResourceNotFoundException {
        List<Estimate> estimateEntity = estimateService.getAllSprintEstimate(sprintName);
        List<EstimateDTO> estimateDTO = EstimateMapper.toDTOList(estimateEntity);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Successfully fetched all Active Sprint details");
        apiResponse.setData(estimateDTO);
        apiResponse.setStatus("Success");
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PutMapping("/updateEstimate")
    public ResponseEntity<ApiResponse> updateEstimate(@RequestBody EstimateDTO estimateDTO) throws ResourceNotFoundException {
        Estimate estimateEntity = EstimateMapper.toEntity(estimateDTO);
        Estimate newEstimateEntity = estimateService.UpdateEstimate(estimateEntity);
        estimateDTO = EstimateMapper.toDTO(newEstimateEntity);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Estimate Details are updated successfully");
        apiResponse.setData(estimateDTO);
        apiResponse.setStatus("Success");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);

    }

    @DeleteMapping("/deleteEstimate/{jiraId}")
    public ResponseEntity<ApiResponse> deleteEstimate(@PathVariable int jiraId) throws ResourceNotFoundException {
        estimateService.deleteEstimate(jiraId);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Estimate is Successfully deleted");
        apiResponse.setData(Collections.emptyList());
        apiResponse.setStatus("Success");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }



    

}
