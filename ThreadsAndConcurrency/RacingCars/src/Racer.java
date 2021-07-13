public class Racer implements Runnable {
    Car c;
    int distance = 1000; // this is a racer that is going to run 1000 miles.

    public Racer(Car car) {
        this.c = car;
    }
    @Override
    public void run()  {
        while (c.odometer < distance) {
            if (c.miles == 0) {
                System.out.println(c.name + "is charging...");
                c.charge();
                try {
                    Thread.sleep((long) c.maxMiles);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } else
                c.move(1);
        }
    }
}
