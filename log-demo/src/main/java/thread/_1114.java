package thread;

/**
 * @author pppppp
 * @date 2022/1/12 10:15
 * 线程的顺序执行
 */
public class _1114 {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = {1, 2, 3};
        Foo foo = new Foo();

        new Thread(() -> {
            try {
                Thread.sleep((int) Math.random() * 1000);
                System.out.println(" foo.third thread start");
                foo.third(new MyThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep((int) Math.random() * 1000);
                System.out.println(" foo.second thread start");
                foo.second(new MyThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep((int) Math.random() * 1000);
                System.out.println(" foo.first thread start");
                foo.first(new MyThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


}

class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

class Foo {
    private static int count = 1;

    public Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (count != 1) {
            wait();
        }
        System.out.println(1);
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count = 2;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (count != 2) {
            wait();
        }
        System.out.println(2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count = 3;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (count != 3) {
            wait();
        }
        System.out.println(3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}