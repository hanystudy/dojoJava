package name.hanyi.benchmark.category;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;

public class GroupByBenchmark implements Benchmark {
    @Override
    public void run(BaseDataStructure<String> dataStructure) throws IOException {
        dataStructure.groupBy(e -> e.substring(0, 0));
    }

    @Override
    public String getName() {
        return "GroupBy";
    }
}
