package JavaCore.thread.chapterFive.Future;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejectedExcutionHandleer implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + "被拒绝");
    }

    public static void main(String[] args) {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        executor.setRejectedExecutionHandler(new MyRejectedExcutionHandleer());

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });

        // 停止接收任务
        executor.shutdown();

        //触发自定义拒绝策略
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
            }
        });

    }

}
