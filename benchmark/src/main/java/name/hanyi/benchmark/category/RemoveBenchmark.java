package name.hanyi.benchmark.category;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;

public class RemoveBenchmark implements Benchmark {
    @Override
    public void run(BaseDataStructure<String> dataStructure) throws IOException {
        dataStructure.clear();
    }

    @Override
    public String getName() {
        return "Remove";
    }
}
