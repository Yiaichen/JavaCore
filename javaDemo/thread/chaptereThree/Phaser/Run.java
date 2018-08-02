package javaDemo.thread.chaptereThree.Phaser;

import java.util.concurrent.Phaser;

public class Run {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);

        ThreadA a = new ThreadA(phaser);

        a.start();
    }

}
