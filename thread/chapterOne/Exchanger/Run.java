package thread.chapterOne.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Exchanger 交换两个线程的值
 * 如果未出现交换线程则阻塞
 * exchanger()可以设置失效时间
 */
public class Run {

    public static void main(String[] args) {

        Exchanger exchanger = new Exchanger();
        ThreadA threadA = new ThreadA(exchanger);
        ThreadB threadB = new ThreadB(exchanger);

        threadA.start();
        threadB.start();
        System.out.println("is end...");

    }

}
