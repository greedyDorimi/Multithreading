package FooBar;

public class FooBar {
    public static Integer times = 0;
    Object object = new Object();

    public void printFoo() throws InterruptedException {
        synchronized(object) {
            while(times == 1) {
                object.wait();
            }
            System.out.print("foo");
            times++;
            object.notify();
        }
    }

    public void printBar() throws InterruptedException {
        synchronized(object) {
            while(times == 0) {
                object.wait();
            }
            System.out.println("bar");
            times--;
            object.notify();
        }
    }
}
