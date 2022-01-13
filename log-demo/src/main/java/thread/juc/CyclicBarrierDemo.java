package thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author pppppp
 * @date 2022/1/13 15:16
 */
public class CyclicBarrierDemo {
    private static final int NUMBER = 7;
    public static void main(String[] args){

        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, () -> {
            System.out.println("finished...");
        });
        for (int i = 0; i < 6; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(finalI);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
