package com.async_jobs;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {

    @PostMapping
    ResponseEntity<String> getJob(Job job) {

    }

}
