package com.example.flinkwebapp.repository;

import com.example.flinkwebapp.Dto.FlinkJobs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlinkJobRepository extends MongoRepository<FlinkJobs, String> {
    boolean existsByJobName(String jobName); // To check if the job name is unique
}
