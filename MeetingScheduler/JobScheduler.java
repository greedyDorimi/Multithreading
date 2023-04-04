package MeetingScheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class JobScheduler {
    private Map<String, Job> jobs = new HashMap<>();
    private Map<String, ScheduledFuture> sf = new HashMap<>();
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);


    public void addJob(String jobId, JobType jobType, Runnable task, Boolean recurring, Long interval) {
        Job job = new Job(jobId, jobType, task, recurring, interval);
        jobs.put(jobId, job);
        if(recurring) {
            sf.put(jobId, executorService.scheduleAtFixedRate(job.task, 1, interval, TimeUnit.MILLISECONDS));
        } else {
            executorService.submit(job.task);
            jobs.remove(jobId);
        }
    }

    public void remove(String jobId) throws InterruptedException {
        Thread.sleep(10);
        ScheduledFuture job = sf.get(jobId);
        job.cancel(true);
    }


}
