package com.example.flinkwebapp.controllers;


import com.example.flinkwebapp.Dto.FlinkJobs;
import com.example.flinkwebapp.repository.FlinkJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/jobs")
public class JobSubmitController {

    @Autowired
    FlinkJobRepository  flinkJobRepository;

    @PostMapping("/submit")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> runFlinkJob(@RequestParam String jobName) {
        Optional<FlinkJobs> optionalJobDetails = flinkJobRepository.findByJobName(jobName);
        if (optionalJobDetails.isEmpty()) {
            return ResponseEntity.badRequest().body("Job with name " + jobName + " not found in MongoDB.");
        }
        try {
            return ResponseEntity.ok("Flink job '" + jobName + "' started successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to start Flink job: " + e.getMessage());
        }

    }

}
