import name.hanyi.marathon.Runner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MarathonMain {
    public static void main(String[] args) {
        List<Runner> runners = Arrays.asList(new Runner("A"),
                new Runner("B"),
                new Runner("C"));

        List<Callable<String>> tasks = runners.stream()
            .map(runner -> {
                Callable<String> task = () -> {
                    runner.run(100);
                    return runner.getName();
                };
                return task;
            })
            .collect(Collectors.toList());

        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<String> service = new ExecutorCompletionService<String>(executor);
        try {
            int size = tasks.size();
            tasks.stream()
                .forEach(task -> {
                    service.submit(task);
                });
            for (int j = 0; j < size; j++) {
                try {
                    String result = service.take().get();
                    System.out.println(result + " wins " + (j + 1) + " place.");
                } catch (ExecutionException ex) {}
            }
            executor.shutdown();
            System.out.println("finish!");
        } catch (InterruptedException ex) {}
    }
}
