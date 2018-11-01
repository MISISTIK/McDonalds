package homework.McDonalds;

public class Cashdesk {

    volatile boolean closed = false;

    public Cashdesk() {
        vilnaKassa();
    }

    String getFood() {
        Double rand = Math.random();
        if (rand > 0.7) {
            closed = true;
        }
        return " gets his ordered food (rand = " + String.format("%.2f",rand) + ")";
    }

    void vilnaKassa() {
        if (!closed) {
            System.out.println("      Vilna Kassa!");
        } else {
            System.out.println("   Cashdesk closed >__<");
        }
    }

}
