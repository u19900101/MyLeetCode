package thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author pppppp
 * @date 2022/1/13 10:52
 */
public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask(() -> {
            System.out.println(Thread.currentThread().getName());
            return "kkk";
        });
        new Thread(futureTask).start();
        String s = futureTask.get();
        System.out.println(s);

        FutureTask futureTask1 = new FutureTask<>(new MyCallable());
        new Thread(futureTask1).start();
        /*while (!futureTask1.isDone()){
            System.out.println("futureTask1 is not Done");
        }*/
        System.out.println(futureTask1.get());

        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}

class MyCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        return 1;
    }
}


