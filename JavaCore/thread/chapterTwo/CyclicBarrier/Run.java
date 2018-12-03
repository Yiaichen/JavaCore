package JavaCore.thread.chapterTwo.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * 相对CountDownLatch来说  CyclicBarrier是加法  加到临界值则释放
 */
public class Run {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("全部都到齐了");
            }
        });

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((int) (Math.random() * 1000));
                        System.out.println(Thread.currentThread().getName() + "到了");
                        /**
                         * 到了之后进行阻塞
                         * 一直等到达临界值 然后执行run方法再往下执行
                         * 并且到达临界值的时候会归零当前阻塞的线程  然后如果有新的线程进来的话继续跑新的一轮等待
                         */
                        cyclicBarrier.await();
                        Thread.sleep((int) (Math.random() * 1000));
                        System.out.println(Thread.currentThread().getName() + "完了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }

}
