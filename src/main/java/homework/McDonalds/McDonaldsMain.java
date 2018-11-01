package homework.McDonalds;

import java.util.concurrent.Semaphore;

public class McDonaldsMain {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Cashdesk cashdesk = new Cashdesk();

        for (int i = 1; i < 11; i++) {
            new HungryCustomer("Man " + String.valueOf(i), cashdesk, semaphore);
        }
    }
}
