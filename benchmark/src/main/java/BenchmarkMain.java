import name.hanyi.benchmark.BenchmarkRunner;
import name.hanyi.benchmark.datastructure.BaseDataStructure;
import name.hanyi.benchmark.datastructure.HArrayList;
import name.hanyi.benchmark.datastructure.HCopyOnWriteArrayList;
import name.hanyi.benchmark.datastructure.HHashSet;
import name.hanyi.benchmark.datastructure.HLinkedList;
import name.hanyi.benchmark.datastructure.HVector;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BenchmarkMain {

    private static BenchmarkRunner runner;
    private static List<BaseDataStructure<String>> dataStructures = Arrays.asList(
            new HArrayList<>(),
            new HLinkedList<>(),
            new HVector<>(),
            new HCopyOnWriteArrayList<>(),
            new HHashSet<>()
    );

    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resourceUrl = BenchmarkMain.class.getClassLoader().getResource("dic.txt");
        Path path = Paths.get(resourceUrl.toURI());
        runner = new BenchmarkRunner(path);
        for (BaseDataStructure<String> dataStructure : dataStructures) {
            runner.execute(dataStructure);
        }
    }
}
