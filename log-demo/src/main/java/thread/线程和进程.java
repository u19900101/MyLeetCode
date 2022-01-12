package thread;

import org.junit.Test;

/**
 * @author pppppp
 * @date 2022/1/12 15:35
 */
public class 线程和进程 {
    public static void main(String[] args){
        Thread mythread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "isDaemon "+  Thread.currentThread().isDaemon());
            int sum = 0;
            while (true){
            }
        }, "mythread");
        mythread.setDaemon(true);
        mythread.start();
        System.out.println(Thread.currentThread().getName() +"is over " );
    }
    @Test
    public void T_守护线程(){

    }
}
