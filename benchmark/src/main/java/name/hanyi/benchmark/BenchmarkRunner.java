package name.hanyi.benchmark;

import name.hanyi.benchmark.category.Benchmark;
import name.hanyi.benchmark.category.ClearBenchmark;
import name.hanyi.benchmark.category.GroupByBenchmark;
import name.hanyi.benchmark.category.ParallelBenchmark;
import name.hanyi.benchmark.category.ReductionBenchmark;
import name.hanyi.benchmark.category.RemoveBenchmark;
import name.hanyi.benchmark.category.SortBenchmark;
import name.hanyi.benchmark.datastructure.BaseDataStructure;
import name.hanyi.benchmark.io.Reader;
import name.hanyi.benchmark.io.SimpleReader;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;

public class BenchmarkRunner {

    private final Reader<String> reader;

    private Benchmark[] benchmarks = new Benchmark[] {
        new CreateBenchmark(),
        new ClearBenchmark(),
        new RemoveBenchmark(),
        new ReductionBenchmark(),
        new ParallelBenchmark(),
        new GroupByBenchmark(),
        new SortBenchmark()
    };

    public BenchmarkRunner(Path path) {
        reader = new SimpleReader(path);
    }

    public void execute(BaseDataStructure<String> dataStructure) throws IOException {
        PrintStream writer = System.out;
        for (Benchmark benchmark : benchmarks) {
            System.gc();
            Instant start = Instant.now();
            long startMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            benchmark.run(dataStructure);
            Instant stop = Instant.now();
            long stopMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            writer.format("Benchmark for %s on %-30s %-10s %10db\n", benchmark.getName(), dataStructure.getName(), Duration.between(start, stop), stopMem - startMem);
        }
    }

    private class CreateBenchmark implements Benchmark {
        @Override
        public void run(BaseDataStructure<String> dataStructure) throws IOException {
            reader.read(dataStructure);
        }

        @Override
        public String getName() {
            return "Create";
        }
    }
}
