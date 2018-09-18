package name.hanyi.countoff;

public class CountOff implements Runnable {

    private Counter counter;

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("start counting!");
        while (!counter.isStop()) {
            int localNumber = counter.getNumber() + 1;
            counter.setNumber(localNumber);
            System.out.println(localNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
        System.out.println("stop counting!");
    }
}
