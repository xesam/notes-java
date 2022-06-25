package io.github.xesam.lang.lang;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.IntStream;

/**
 * Created by xe on 16-5-8.
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                TicketWindow ticketWindow = TicketWindow.prepare();
                IntStream.range(0, 5).forEach(i -> new Buyer("buyer_" + i).enqueue());
                ticketWindow.open();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                TicketWindow ticketWindow = TicketWindow.prepare();
                IntStream.range(5, 10).forEach(i -> new Buyer("buyer_" + i).enqueue());
                ticketWindow.open();
            }
        }.start();
    }
}

class TicketWindow {

    private static ThreadLocal<TicketWindow> sTicketWindow = new ThreadLocal<TicketWindow>() {
        public TicketWindow initialValue() {
            return new TicketWindow(Thread.currentThread().getName());
        }
    };

    public static TicketWindow prepare() {
        return sTicketWindow.get();
    }

    private String name;
    private BuyerQueue buyerQueue;

    public TicketWindow(String name) {
        this.name = name;
        this.buyerQueue = new BuyerQueue();
    }

    public String getName() {
        return name;
    }

    public void enqueue(Buyer buyer) {
        buyerQueue.enqueue(buyer);
        System.out.println("enqueue:" + buyer.getName());
    }

    public void open() {
        while (true) {
            Buyer buyer = buyerQueue.poll();
            if (buyer != null) {
                System.out.println(getName() + " turn:" + buyer.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buyer.buy();
                System.out.println(getName() + " sold:" + buyer.getName());
            }
        }
    }
}

class BuyerQueue {
    private Queue<Buyer> queue = new LinkedBlockingDeque<>();

    public void enqueue(Buyer buyer) {
        queue.add(buyer);
    }

    public Buyer poll() {
        return queue.poll();
    }

}

class Buyer {

    private String name;

    public Buyer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enqueue() {
        TicketWindow ticketWindow = TicketWindow.prepare();
        ticketWindow.enqueue(this);
    }

    public void buy() {
    }
}
