package MeetingScheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {
    private final Map<String, Job> jobs = new HashMap<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    public void addJob(String jobId, JobType jobType, Runnable task, Boolean recurring, Long interval) {
        Job job = new Job(jobId, jobType, task, recurring, interval);
        jobs.put(jobId, job);
        if(recurring) {
            executorService.scheduleAtFixedRate(() -> {
                Job recurringJob = jobs.get(jobId);
                if (recurringJob != null) {
                    recurringJob.run();
                }
            }, 0, interval, TimeUnit.MILLISECONDS);
        }
    }
}
