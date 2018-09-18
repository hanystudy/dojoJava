package name.hanyi.countoff;

public class CountOffWatch implements Runnable {

    private Counter counter;
    private static final int STOP_NUMBER = 5;

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("watching start!");
        while(counter.getNumber() < STOP_NUMBER) {}
        counter.stop();
        System.out.println("watching done!");
    }
}
