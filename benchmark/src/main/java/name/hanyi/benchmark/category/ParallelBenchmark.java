package name.hanyi.benchmark.category;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;

public class ParallelBenchmark implements Benchmark {
    @Override
    public void run(BaseDataStructure<String> dataStructure) throws IOException {
        dataStructure.parallel(e -> e.toUpperCase());
    }

    @Override
    public String getName() {
        return "Parallel";
    }
}
