package com.async_jobs;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.function.Consumer;

@Data
public class Job {

    private final String id;
    private final LocalDateTime createdAt;

    private volatile JobStatus status;
    private volatile int progress;

    private final Consumer<Job> action;


}
