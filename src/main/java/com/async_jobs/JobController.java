package com.async_jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/start")
    ResponseEntity<String> startJob() {
        String id = jobService.startJob();
        return ResponseEntity.ok(id);
    }
}
