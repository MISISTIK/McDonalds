package homework.McDonalds;

import java.util.concurrent.Semaphore;

public class HungryCustomer implements Runnable {

    private Semaphore semaphore;
    private Cashdesk cashdesk;
    private String name;


    public HungryCustomer(String name, Cashdesk cashdesk, Semaphore semaphore) {
        this.name = name;
        this.cashdesk = cashdesk;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!cashdesk.closed) {
            System.out.println(name + cashdesk.getFood());
            cashdesk.vilnaKassa();
        }
        semaphore.release();
    }

}
