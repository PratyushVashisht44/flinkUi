package com.example.flinkwebapp.controllers;

import com.example.flinkwebapp.Dto.FlinkJobs;
import com.example.flinkwebapp.services.FlinkJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/create")
public class FlinkJobController {
    @Autowired
    private FlinkJobService flinkJobService;

    @PostMapping("")
    public ResponseEntity<String> createFlinkJob(@RequestBody FlinkJobs flinkJobDTO) {
        String response = flinkJobService.saveFlinkJob(flinkJobDTO);
        if (response.equals("Job name already exists!")) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}
