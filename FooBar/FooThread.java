package FooBar;

public class FooThread implements Runnable {
    private FooBar fooBar;
    public FooThread(FooBar fooBar) {
        this.fooBar = fooBar;
    }
    @Override
    public void run() {
        try {
            fooBar.printFoo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}