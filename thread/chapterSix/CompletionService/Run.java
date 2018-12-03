package thread.chapterSix.CompletionService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * CompletionService的唯一实现类ExecutorCompletionService
 * take() 阻塞方法 可以异步获取执行结果
 * poll() 非阻塞方法 无任务返回时返回null
 */
public class Run {

    public static void main(String[] args) {

        MyCallable myCallable1 = new MyCallable(5000, "userName1");
        MyCallable myCallable2 = new MyCallable(4000, "userName2");
        MyCallable myCallable3 = new MyCallable(3000, "userName3");
        MyCallable myCallable4 = new MyCallable(2000, "userName4");
        MyCallable myCallable5 = new MyCallable(1000, "userName5");

        List<MyCallable> myCallables = new ArrayList<>();
        myCallables.add(myCallable1);
        myCallables.add(myCallable2);
        myCallables.add(myCallable3);
        myCallables.add(myCallable4);
        myCallables.add(myCallable5);


        // Future提交任务
        List<Future> futureList = new ArrayList<>();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        CompletionService completionService = new ExecutorCompletionService(threadPoolExecutor);

        // 提交任务
        for (int i = 0; i < myCallables.size(); i++) {
            completionService.submit(myCallables.get(i));
            futureList.add(threadPoolExecutor.submit(myCallables.get(i)));
        }

        // 获取结果  如果是5秒同时返回则为同步   反之异步
        for (int i = 0; i < futureList.size(); i++) {
            System.out.println("Future打印第" + i + "个返回值");
            try {
                System.out.println("Future " + futureList.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 获取结果  如果是5秒同时返回则为同步   反之异步
        for (int i = 0; i < myCallables.size(); i++) {
            System.out.println("打印第" + i + "个返回值");
            try {
                Future take = completionService.take();

                // get()方法还是会阻塞的   所以获取完一个就走下一个
                System.out.println(take.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("执行完毕!");

    }

}
