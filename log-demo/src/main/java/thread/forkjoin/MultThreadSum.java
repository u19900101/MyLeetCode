package thread.forkjoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author pppppp
 * @date 2022/1/13 20:57
 * 多线程进行求和
 */
public class MultThreadSum {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int  j= 0; j < 5; j++) {
            long s = System.currentTimeMillis();
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            MyJoin myJoin = new MyJoin(0, 1000000+j);
            ForkJoinTask<Integer> submit = forkJoinPool.submit(myJoin);
            System.out.println(System.currentTimeMillis() - s);
            System.out.println(submit.get());
            forkJoinPool.shutdown();

            s = System.currentTimeMillis();
            int sum = 0;
            for (int i = 0; i <= 1000000+j; i++) {
                sum += i;
            }
            System.out.println(System.currentTimeMillis() - s);
            System.out.println(sum);
            System.out.println("--------------------------");
        }

    }

    @Test
    public void T_(){
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.valueOf(i) +  "--> "+ (i>> 1));
        }
    }
}

class MyJoin extends RecursiveTask<Integer> {
    private static Integer VALUE = 10;
    private int start;
    private int end;
    private int sum = 0;

    MyJoin(int start,int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        if(end -start<= 10){
            for (int i = start; i <= end; i++) {
                sum += i;
                // System.out.println("sum :" + sum  + "  i: " + i);
            }
        }else {
            int mid = start + ((end -start)>> 1);
            // int mid = (end +start) /2;
            MyJoin taskLeft = new MyJoin(start, mid);
            MyJoin taskRight = new MyJoin(mid + 1, end);
            taskLeft.fork();
            taskRight.fork();
            sum = taskLeft.join() + taskRight.join();
        }
        return sum;
    }


}