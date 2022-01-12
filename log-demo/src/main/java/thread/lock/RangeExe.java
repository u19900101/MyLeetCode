package thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pppppp
 * @date 2022/1/12 20:46
 */
public class RangeExe {
    public static void main(String[] args){
        ShareResource shareResource = new ShareResource();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() ->{
                shareResource.funcB(finalI);
            },"funcB" + i).start();
            new Thread(() ->{
                shareResource.funcC(finalI);
            },"funcC" + i).start();
            new Thread(() ->{
                shareResource.funcA(finalI);
            },"funcA" + i).start();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}

class ShareResource {
    private Lock lock = new ReentrantLock();
    private int flag = 1;
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void funcA(int loop){
        lock.lock();
        try {
            while (flag != 1){
                c1.await();
            }
            flag++;
            System.out.println("funcA...  " + loop);
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void funcB(int loop){
        lock.lock();
        try {
            while (flag != 2){
                c2.await();
            }
            flag++;
            System.out.println("funcB...  " + loop);
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void funcC(int loop){
        lock.lock();
        try {
            while (flag != 3){
                c3.await();
            }
            flag = 1;
            System.out.println("funcC...  " + loop);
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
