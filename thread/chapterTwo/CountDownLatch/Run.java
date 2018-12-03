package thread.chapterTwo.CountDownLatch;


import java.util.concurrent.CountDownLatch;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService();
//
//        new MyThread(myService).start();
//
//        Thread.sleep(2000);
//
//        myService.downMethod();

        CountDownLatch countDownLatch = new CountDownLatch(10);

        MyThread[] arr = new MyThread[Integer.parseInt("" + countDownLatch.getCount())];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new MyThread(myService);
            arr[i].setName("线程" + (i + 1));
            arr[i].start();
        }
        Thread.sleep(2000);
        myService.downMethod();
    }

}
