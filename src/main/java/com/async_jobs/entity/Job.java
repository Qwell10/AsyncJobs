package com.async_jobs.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.function.Consumer;

/*
@Getter //Lombok doesent work, i think i tried everything :(
@Setter
*/
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

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public JobStatus getStatus() {
        return status;
    }

    public int getProgress() {
        return progress;
    }

    public Consumer<Job> getAction() {
        return action;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
