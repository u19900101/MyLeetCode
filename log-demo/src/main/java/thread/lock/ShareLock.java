package thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pppppp
 * @date 2022/1/12 20:14
 */

public class ShareLock {
    public static void main(String[] args) {
        Share share = new Share();
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                for (int j = 0; j < 15; j++) {
                    try {
                        share.incr();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "add " + (i + 1)).start();
            new Thread(() -> {
                for (int j = 0; j < 15; j++) {
                    try {
                        share.decr();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "decr " + (i + 1)).start();
        }
    }
    static class Share {
        private int count = 0;
        private Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        public void incr() throws InterruptedException {
            lock.lock();
            try {
                while (count != 0){
                    condition.await();
                }
                count++;
                System.out.println(Thread.currentThread().getName() + " --> " + count);
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }

        public void decr() throws InterruptedException {
            lock.lock();
            try {
                while (count != 1){
                    condition.await();
                }
                count--;
                System.out.println(Thread.currentThread().getName() + " --> " + count);
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }
}



