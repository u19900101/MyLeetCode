package thread.jucclass;

import java.util.concurrent.CountDownLatch;

/**
 * @author pppppp
 * @date 2022/1/13 15:02
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " leave classroom");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("Lock the door...");
    }
}
