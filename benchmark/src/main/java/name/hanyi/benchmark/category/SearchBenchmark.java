package name.hanyi.benchmark.category;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;

public class SearchBenchmark implements Benchmark {
    @Override
    public void run(BaseDataStructure<String> dataStructure) throws IOException {
        dataStructure.search("z", (e1, e2) -> e1.compareToIgnoreCase(e2));
    }

    @Override
    public String getName() {
        return "Search";
    }
}
