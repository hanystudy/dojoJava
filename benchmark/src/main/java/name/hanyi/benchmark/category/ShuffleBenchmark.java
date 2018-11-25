package name.hanyi.benchmark.category;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;
import java.util.Random;

public class ShuffleBenchmark implements Benchmark {
    @Override
    public void run(BaseDataStructure<String> dataStructure) throws IOException {
        dataStructure.shuffle(new Random());
    }

    @Override
    public String getName() {
        return "Shuffle";
    }
}
