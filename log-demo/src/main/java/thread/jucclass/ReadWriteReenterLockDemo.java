package thread.jucclass;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author pppppp
 * @date 2022/1/13 16:06
 */
public class ReadWriteReenterLockDemo {
    public static void main(String[] args){
        Resource resource = new Resource();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            int finalI1 = i;
            new Thread(()->{
                try {
                    resource.put(String.valueOf(finalI), finalI1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Integer integer = resource.get(String.valueOf(finalI));
                    System.out.println(integer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}

class Resource{
    public  volatile  HashMap<String,Integer> map = new HashMap<>();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public int get(String key) throws InterruptedException {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " on getting...");
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            System.out.println(Thread.currentThread().getName() + " got..");
        }finally {
            rwLock.readLock().unlock();
        }

        return map.get(key);
    }

    public void put(String key, Integer value) throws InterruptedException {

        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " on putting...");
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()   + " put done..");
        }finally {
            rwLock.writeLock().unlock();
        }

    }
}
