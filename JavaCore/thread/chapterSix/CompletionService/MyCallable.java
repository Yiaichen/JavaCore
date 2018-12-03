package JavaCore.thread.chapterSix.CompletionService;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private long sleepValue;

    private String userName;

    public MyCallable(long sleepValue, String userName) {
        super();
        this.sleepValue = sleepValue;
        this.userName = userName;
    }

    @Override
    public String call() throws Exception {

        System.out.println(userName);
        Thread.sleep(sleepValue);
        return "return " + userName;

    }
}
