package MeetingScheduler;

public class Job {
    String JobId;
    JobType jobType;
    Runnable task;
    Boolean recurring;
    Long interval;

    public Job(String jobId, JobType jobType, Runnable task, Boolean recurring, Long interval) {
        JobId = jobId;
        this.jobType = jobType;
        this.task = task;
        this.recurring = recurring;
        this.interval = interval;
    }
    public void run() {
        task.run();
    }
}
