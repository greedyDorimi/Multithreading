package BlockingQueue;

import java.io.IOException;

public class Demonstration {
    public static void main(String[] args) throws Exception {
        final BlockingQueue<Integer> q = new BlockingQueue<Integer>(50);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        q.enqueue(i);
                        System.out.println("enqueued " + i);
                    }
                } catch (InterruptedException ie) {
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Thread 2 dequeued: " + q.dequeue());
                    }
                } catch (InterruptedException ie) {
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Thread 3 dequeued: " + q.dequeue());
                    }
                } catch (InterruptedException ie) {
                } }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}

//int times = 0;
//
//void foo() {
//    synchronized (lock) {
//        while(times == 1) {
//            wait();
//        }
//        print foo;
//        times--;
//        notifyAll();
//    }
//}
//
//void bar() {
//    synchronized (lock) {
//        while(times == 0) {
//            wait();
//        }
//        print bar;
//        times++;
//        notifyAll();
//    }
//}
//t1 {
//    for(i = 0 -> n/2) {
//        new thread()
//                threa.strt
//    }
//}
//
//t2 {
//    for(i = 0 -> n/2) {
//        bar();
//    }
//}
//
//t1.start();
//t2.start();
//t1.join();
//t2.join();
//
//
