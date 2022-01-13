package thread.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author pppppp
 * @date 2022/1/13 19:43
 */
public class ThreadPoolDemo {
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        /*可扩容线程*/
        // ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + " is running...");
            });
        }
        threadPool.shutdown();
    }
}
