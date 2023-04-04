package FooBar;

public class BarThread implements Runnable {
    FooBar fooBar;
    public BarThread(FooBar fooBar) {
        this.fooBar = fooBar;
    }
    @Override
    public void run() {
        try {
            fooBar.printBar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
