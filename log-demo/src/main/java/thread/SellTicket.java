package thread;

/**
 * @author pppppp
 * @date 2022/1/12 16:00
 */
public class SellTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 15; j++) {
                    ticket.sellTicket();
                }
            }, String.valueOf(i + 1)).start();
        }
    }
}

class Ticket {
    private int count = 30;

    public synchronized void sellTicket() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + " -- Count :" + count + " --> " + --count);
        } else {
            System.out.println(Thread.currentThread().getName() + " -- 卖完了");
        }

    }
}