package com.example.flinkwebapp.services;

import com.example.flinkwebapp.Dto.FlinkJobs;
import com.example.flinkwebapp.repository.FlinkJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlinkJobService {

    @Autowired
    private FlinkJobRepository flinkJobRepository;

    public String saveFlinkJob(FlinkJobs flinkJobDTO) {
        // Check if the job name is unique
        if (flinkJobRepository.existsByJobName(flinkJobDTO.getJobName())) {
            return "Job name already exists!";
        }

        // Convert DTO to entity
        FlinkJobs flinkJob = new FlinkJobs();
        flinkJob.setJobName(flinkJobDTO.getJobName());
        flinkJob.setUsername(flinkJobDTO.getUsername());
        flinkJob.setConfigurations(flinkJobDTO.getConfigurations());

        // Save to MongoDB
        flinkJobRepository.save(flinkJob);

        return "Job saved successfully!";
    }
}
