package name.hanyi.benchmark;

import name.hanyi.benchmark.category.Benchmark;
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
        new CreateBenchmark()
    };

    public BenchmarkRunner(Path path) {
        reader = new SimpleReader(path);
    }

    public void execute(BaseDataStructure<String> dataStructure) throws IOException {
        PrintStream writer = System.out;
        for (Benchmark benchmark : benchmarks) {
            Instant start = Instant.now();
            benchmark.run(dataStructure);
            Instant stop = Instant.now();
            writer.format("Benchmark for %s on %s: %s\n", benchmark.getName(), dataStructure.getName(), Duration.between(start, stop));
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
