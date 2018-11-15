package name.hanyi.benchmark.category;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;
import java.util.Collections;

public class ClearBenchmark implements Benchmark {
    @Override
    public void run(BaseDataStructure<String> dataStructure) throws IOException {
        dataStructure.removeAll(Collections.singleton("kazatsky"));
    }

    @Override
    public String getName() {
        return "Clear";
    }
}
