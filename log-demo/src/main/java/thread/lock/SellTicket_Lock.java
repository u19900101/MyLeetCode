package thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pppppp
 * @date 2022/1/12 16:23
 */

public class SellTicket_Lock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 15; j++) {
                    ticket.sellTicket();
                }
            }, String.valueOf(i + 1)).start();
        }
    }
    static class Ticket {
        private int count = 30;
        private final ReentrantLock lock = new ReentrantLock();
        public void sellTicket() {
            lock.lock();
            try {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + " -- Count :" + count + " --> " + --count);
                } else {
                    System.out.println(Thread.currentThread().getName() + " -- 卖完了");
                }
            }finally {
                lock.unlock();
            }
        }
    }
}


