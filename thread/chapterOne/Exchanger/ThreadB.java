package thread.chapterOne.Exchanger;

import java.util.concurrent.Exchanger;

public class ThreadB extends Thread {

    private Exchanger exchanger;

    public ThreadB(Exchanger exchanger) {
        super();
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("B线程获取的交换值:" + exchanger.exchange("交换值B"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
