package name.hanyi.countoff;

public class Counter {
    private volatile int number = 0;
    private boolean stop = false;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
    
    public void stop() {
        this.stop = true;
    }
    
    public boolean isStop() {
        return stop;
    }
}
