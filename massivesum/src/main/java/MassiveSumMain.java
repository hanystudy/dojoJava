import name.hanyi.massivesum.SumTask;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MassiveSumMain {
    public static void main(String[] args) {
        int[] input = new int[100000];
        Random random = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(100);
        }
        SumTask sumTask = new SumTask(input);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.execute(sumTask);
        System.out.println(sumTask.join());
    }
}
