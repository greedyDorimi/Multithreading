package FooBar;

public class Driver {
    public static void main(String[] args) throws Exception {
        FooBar fooBar = new FooBar();
        int n = 10;
        for(int i = 1; i <= n/2; i++) {
            Thread foo = new Thread(new FooThread(fooBar));
            foo.start();
        }
        for(int i = 1; i <= n/2; i++) {
            Thread bar = new Thread(new BarThread(fooBar));
            bar.start();
        }
    }
}
