package MeetingScheduler;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        JobScheduler jobScheduler = new JobScheduler();
        jobScheduler.addJob("1", JobType.RECURRING, new Runnable() {
            @Override
            public void run() {
                System.out.println("task-1");
            }
        }, true, 1L);
        jobScheduler.remove("1");
    }

}
