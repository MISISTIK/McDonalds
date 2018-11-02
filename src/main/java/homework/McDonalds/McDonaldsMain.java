package homework.McDonalds;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class McDonaldsMain {

    public static CountDownLatch BARRIER = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            Semaphore semaphore = new Semaphore(1);
            Cashdesk cashdesk = new Cashdesk();

            for (int i = 1; i < 11; i++) {
                new HungryCustomer("Man " + String.valueOf(i), cashdesk, semaphore);
            }

            Thread.sleep(100);
            cashdesk.vilnaKassa();
            BARRIER.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
