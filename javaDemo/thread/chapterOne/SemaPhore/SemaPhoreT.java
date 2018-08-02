package javaDemo.thread.chapterOne.SemaPhore;

import java.util.concurrent.Semaphore;

/**
 * 同一时间内  限制多个线程通过
 */
public class SemaPhoreT {

    private Semaphore semaphore = new Semaphore(2);

    public void testMethod() {

        try {
            //限制
            semaphore.acquire();

            System.out.println(Thread.currentThread().getName() + " begin time:" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end time:" + System.currentTimeMillis());

            //释放
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 尝试获取
     */
    public void testMethod1() {

        try {
            //限制
            if (semaphore.tryAcquire()) {
                System.out.println(Thread.currentThread().getName() + " begin time:" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " end time:" + System.currentTimeMillis());
                //释放
                semaphore.release();
            } else {
                System.out.println(Thread.currentThread().getName() + " 未获取到许可");
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SemaPhoreT semaPhoreT = new SemaPhoreT();

        new Thread(new Runnable() {
            @Override
            public void run() {
                semaPhoreT.testMethod();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                semaPhoreT.testMethod();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                semaPhoreT.testMethod();
            }
        }).start();

    }
}
