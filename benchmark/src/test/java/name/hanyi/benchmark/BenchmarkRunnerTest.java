package name.hanyi.benchmark;

import name.hanyi.benchmark.datastructure.BaseDataStructure;
import name.hanyi.benchmark.datastructure.HArrayList;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BenchmarkRunnerTest {

    private BenchmarkRunner runner;

    @Before
    public void setUp() throws URISyntaxException {
        URL resourceUrl = getClass().getClassLoader().getResource("dic.txt");
        Path path = Paths.get(resourceUrl.toURI());
        runner = new BenchmarkRunner(path);
    }

    @Test
    public void testRun() throws IOException {
        BaseDataStructure<String> dataStructure = new HArrayList<>();
        runner.execute(dataStructure);
    }
}