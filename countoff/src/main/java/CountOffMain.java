import name.hanyi.countoff.Counter;
import name.hanyi.countoff.CountOff;
import name.hanyi.countoff.CountOffWatch;

public class CountOffMain {

    public static void main(String args[]) {
        CountOff countOff = new CountOff();
        CountOffWatch countOffWatch = new CountOffWatch();
        Counter counter = new Counter();
        countOff.setCounter(counter);
        countOffWatch.setCounter(counter);
        
        Thread threadA = new Thread(countOff);
        Thread threadB = new Thread(countOffWatch);
        threadB.start();
        threadA.start();
    }
}
