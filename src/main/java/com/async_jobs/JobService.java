package com.async_jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class JobService {

    @Autowired
    JobManager jobManager;

    public String startJob() {
        return jobManager.startJob(simulateProgressLogic());
    }

    public Consumer<Job> simulateProgressLogic() {
        return (job) -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                    job.setProgress(i * 10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Job interrupted");
                    return;
                }
            }
        };
    }

}
