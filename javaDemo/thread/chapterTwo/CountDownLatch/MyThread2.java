package javaDemo.thread.chapterTwo.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class MyThread2 extends Thread {

    private CountDownLatch count;

    public MyThread2(CountDownLatch count) {
        super();
        this.count = count;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            count.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
