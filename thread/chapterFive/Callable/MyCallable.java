package thread.chapterFive.Callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {

        for (; ; ) {

            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException();
            }

            System.out.println("进入callable执行");
        }

    }
}
