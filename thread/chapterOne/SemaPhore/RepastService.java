package thread.chapterOne.SemaPhore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Semaphore实现生产者、消费者
 * created by cheng on 2018/5/16
 */
public class RepastService {

    /**
     * 设置5个厨师（生产者）
     */
    private volatile Semaphore setSemaphore = new Semaphore(5);

    /**
     * 设置10个顾客（消费者）
     */
    private volatile Semaphore getSemaphore = new Semaphore(10);

    private volatile ReentrantLock reentrantLock = new ReentrantLock();
    private volatile Condition setCondition = reentrantLock.newCondition();
    private volatile Condition getCondition = reentrantLock.newCondition();

    /**
     * 最多一次上4盘菜
     */
    private volatile Object[] producePosition = new Object[4];

    private boolean isEmpty() {

        boolean isEmpty = true;
        for (int i = 0; i < producePosition.length; i++) {
            if (producePosition[i] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;

    }

    /**
     * 判断有没有空盘子
     *
     * @return true：没有空盘子 反之则有
     */
    private boolean isFull() {

        boolean isFull = true;
        for (int i = 0; i < producePosition.length; i++) {
            if (producePosition[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;

    }

    public void set() {
        try {
            setSemaphore.acquire();
            reentrantLock.lock();
            while (isFull()) {
                //没有空盘子  厨师要等待
                setCondition.await();
            }

            for (int i = 0; i < producePosition.length; i++) {

                if (producePosition[i] == null) {

                    //发现有空盘子了  可以上菜
                    producePosition[i] = "xx菜";
                    System.out.println(Thread.currentThread().getName() + " 生产了 " + producePosition[i]);
                    break;

                }

            }
            //上菜
            getCondition.signalAll();
            reentrantLock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            setSemaphore.release();
        }
    }

    public void get() {
        try {
            getSemaphore.acquire();
            reentrantLock.lock();
            while (isEmpty()) {
                //菜已经上齐了  没盘子装了  吃完了才能上
                getCondition.await();
            }

            for (int i = 0; i < producePosition.length; i++) {
                if (producePosition[i] != null) {
                    //发现有菜上来  可以开饭了
                    System.out.println(Thread.currentThread().getName() + " 消费了 " + producePosition[i]);
                    producePosition[i] = null;
                    break;
                }
            }
            //端盘子下去
            setCondition.signalAll();
            reentrantLock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            getSemaphore.release();
        }
    }

}
