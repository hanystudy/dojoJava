package name.hanyi.massivesum;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinTask;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class SumTask extends RecursiveTask<Integer> {
    private int[] numbers;
    private static final int THRESHOLD = 100;

    public SumTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    protected Integer compute() {
        if (numbers.length > THRESHOLD) {
            List<SumTask> taskList = new ArrayList<>();
            taskList.add(new SumTask(Arrays.copyOfRange(numbers, 0, numbers.length / 2)));
            taskList.add(new SumTask(Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length)));
            return ForkJoinTask.invokeAll(taskList)
                .stream()
                .mapToInt(ForkJoinTask::join)
                .sum();
        } else {
            return Arrays.stream(numbers).sum();
        }
    }
}
