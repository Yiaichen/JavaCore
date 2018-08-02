package javaDemo.thread.chapterOne.Exchanger;

import java.util.concurrent.Exchanger;

public class ThreadA extends Thread {

    private Exchanger exchanger;

    public ThreadA(Exchanger exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("A线程获取的交换值:" + exchanger.exchange("交换值A"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
