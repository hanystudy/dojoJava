package name.hanyi.benchmark.io;

import name.hanyi.benchmark.datastructure.BaseDataStructure;
import name.hanyi.benchmark.datastructure.HArrayList;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReaderTest {

    @Test
    public void testRead() throws URISyntaxException, IOException {
        URL resourceUrl = getClass().getClassLoader().getResource("dic.txt");
        Path path = Paths.get(resourceUrl.toURI());
        BaseDataStructure<String> dataStructure = new HArrayList<>();
        Reader<String> reader = new SimpleReader(path);
        reader.read(dataStructure);
        assertThat(dataStructure.size(), is(80368));
    }
}
