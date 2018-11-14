package name.hanyi.benchmark.category;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;

public interface Benchmark {
    void run(BaseDataStructure<String> dataStructure) throws IOException;

    String getName();
}
