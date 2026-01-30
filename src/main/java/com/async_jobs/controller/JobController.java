package com.async_jobs.controller;

import com.async_jobs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/start")
    public ResponseEntity<String> startJob() {
        String id = jobService.startJob();
        return ResponseEntity.ok("Ticket of your job: " + id);
    }
}
