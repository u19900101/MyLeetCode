package thread.pool;

import java.util.concurrent.*;

/**
 * @author pppppp
 * @date 2022/1/13 20:31
 */
public class MyThreadPool {
    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
                );
        // new ThreadPoolExecutor.AbortPolicy()
        try {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName() +"__ "+ finalI + " is running...");
                });
            }
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
