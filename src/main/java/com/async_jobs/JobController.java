package com.async_jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class JobController {

    @Autowired
    private JobManager jobManager;

    @PostMapping("/submit")
     ResponseEntity<String> startJob(@RequestBody String starter) {

        }
    }

}
