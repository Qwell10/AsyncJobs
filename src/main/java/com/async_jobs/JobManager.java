package com.async_jobs;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import static com.async_jobs.JobStatus.*;

public class JobManager {

    private final Map<String, Job> jobs = new ConcurrentHashMap<>();

    // Single thread - will execute jobs sequentially
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public String startJob(Consumer<Job> logic) {
        String id = UUID.randomUUID().toString();
        Job job = new Job(id, logic);

        jobs.put(id, job);

        executor.submit(() -> {
            try {
                job.setStatus(RUNNING);
                logic.accept(job);
                job.setStatus(COMPLETED);
            } catch (Exception e) {
                job.setStatus(FAILED);
                e.printStackTrace();
            }
        });
        return id;
    }

    private int setProgress(int progress) {

    }
}