package com.example.flinkwebapp.repository;

import com.example.flinkwebapp.Dto.FlinkJobs;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FlinkJobRepository extends MongoRepository<FlinkJobs, String> {
    boolean existsByJobName(String jobName);
    Optional<FlinkJobs> findByJobName(String jobName);// To check if the job name is unique
}
