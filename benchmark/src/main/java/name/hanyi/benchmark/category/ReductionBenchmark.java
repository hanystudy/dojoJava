package name.hanyi.benchmark.category;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;

public class ReductionBenchmark implements Benchmark {
    @Override
    public void run(BaseDataStructure<String> dataStructure) throws IOException {
        dataStructure.reduce(e -> e.toUpperCase());
    }

    @Override
    public String getName() {
        return "Reduction";
    }
}
