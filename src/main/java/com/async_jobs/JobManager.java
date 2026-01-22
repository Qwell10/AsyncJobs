package com.async_jobs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobManager {

    private final Map<String, Job> jobs = new ConcurrentHashMap<>();

    // Single thread - will execute jobs sequentially
    private final ExecutorService executor = Executors.newSingleThreadExecutor(); 
}