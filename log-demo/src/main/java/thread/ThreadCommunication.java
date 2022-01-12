package thread;

/**
 * @author pppppp
 * @date 2022/1/12 16:51
 */
class Share{
    private int count;
    public synchronized void incr() throws InterruptedException {
        /*不能用if*/
        if (count != 0){
            wait();
        }
        count++;
        System.out.println(Thread.currentThread().getName() +" -- " +  count);
        notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        if (count != 1){
            wait();
        }
        count--;
        System.out.println(Thread.currentThread().getName() +" -- " +  count);
        notifyAll();
    }
}
public class ThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        Share share = new Share();
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"decr " + (i+1)).start();
            new Thread(() ->{
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"incr " + (i+1)).start();
        }
    }
}
