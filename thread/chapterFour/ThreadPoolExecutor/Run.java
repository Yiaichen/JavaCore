package thread.chapterFour.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 999, 999L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread begin");

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread end");
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 begin");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread2 end");
            }
        });


        // 线程池未关闭则阻塞一定时间  超过继续往下执行
        threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);

        // 不接受新的任务   当前任务执行完关闭线程池
        threadPoolExecutor.shutdown();

        System.out.println("main thread end");
    }

}
