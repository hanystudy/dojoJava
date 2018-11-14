package name.hanyi.benchmark;

import name.hanyi.benchmark.datastructure.BaseDataStructure;
import name.hanyi.benchmark.datastructure.HArrayList;
import name.hanyi.benchmark.datastructure.HCopyOnWriteArrayList;
import name.hanyi.benchmark.datastructure.HHashSet;
import name.hanyi.benchmark.datastructure.HLinkedList;
import name.hanyi.benchmark.datastructure.HVector;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BenchmarkRunnerTest {

    private BenchmarkRunner runner;

    private List<BaseDataStructure<String>> dataStructures;

    @Before
    public void setUp() throws URISyntaxException {
        URL resourceUrl = getClass().getClassLoader().getResource("dic.txt");
        Path path = Paths.get(resourceUrl.toURI());
        runner = new BenchmarkRunner(path);
        dataStructures = Arrays.asList(
            new HArrayList<>(),
            new HLinkedList<>(),
            new HVector<>(),
            new HCopyOnWriteArrayList<>(),
            new HHashSet<>()
        );
    }

    @Test
    public void testRun() throws IOException {
        for (BaseDataStructure<String> dataStructure : dataStructures) {
            runner.execute(dataStructure);
        }
    }
}