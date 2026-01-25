package com.async_jobs;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.function.Consumer;

@Data
public class Job {

    //final - value must be set and can't be empty and value can't be changed
    private final String id;
    private final LocalDateTime createdAt;

    //volatile
    // - doesn't save to CPU cache, always to Main Memory (RAM).
    // - without volatile user can't see progress (will see 0 and then 100)
    private volatile JobStatus status;
    private volatile int progress;

    private final Consumer<Job> action;

    public Job(String id, Consumer<Job> action) {
        this.id = id;
        this.action = action;

        this.createdAt = LocalDateTime.now();
        this.status = JobStatus.PENDING;
        this.progress = 0;
    }
}
