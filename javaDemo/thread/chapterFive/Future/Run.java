package javaDemo.thread.chapterFive.Future;


import javaDemo.thread.chapterFive.Callable.MyCallable;

import java.util.concurrent.*;

/**
 * Future的缺点就是阻塞影响效率，会等所有任务都获取到返回值才返回
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {

        MyCallable callable = new MyCallable();
        ExecutorService service = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Future<String> submit = service.submit(callable);

        Thread.sleep(2000);
        System.out.println(submit.cancel(true) + " " + submit.isCancelled());
    }

}
