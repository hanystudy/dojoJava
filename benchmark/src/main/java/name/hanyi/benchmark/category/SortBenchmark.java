package name.hanyi.benchmark.category;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;

public class SortBenchmark implements Benchmark {
    @Override
    public void run(BaseDataStructure<String> dataStructure) throws IOException {
        dataStructure.sort((e1, e2) -> e1.compareToIgnoreCase(e2));
    }

    @Override
    public String getName() {
        return "Sort";
    }
}
