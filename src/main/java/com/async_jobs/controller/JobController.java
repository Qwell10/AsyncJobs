package com.async_jobs.controller;

import com.async_jobs.entity.Job;
import com.async_jobs.service.JobManager;
import com.async_jobs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private JobManager jobManager;

    @PostMapping("/start")
    public ResponseEntity<String> startJob() {
        String id = jobService.startJob();
        return ResponseEntity.ok("Ticket of your job: " + id);
    }

    @GetMapping("/getStatus{id}")
    public ResponseEntity<String> getStatus(@PathVariable String id) {
        Job job = jobManager.getJob(id);
        return ResponseEntity.ok(job.getStatus().toString() + " " + job.getProgress());
    }
}
