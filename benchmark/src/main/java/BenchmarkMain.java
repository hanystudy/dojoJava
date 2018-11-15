import name.hanyi.benchmark.BenchmarkRunner;
import name.hanyi.benchmark.datastructure.BaseDataStructure;
import name.hanyi.benchmark.datastructure.deque.HArrayDeque;
import name.hanyi.benchmark.datastructure.deque.HLinkedBlockingDeque;
import name.hanyi.benchmark.datastructure.list.HArrayList;
import name.hanyi.benchmark.datastructure.list.HCopyOnWriteArrayList;
import name.hanyi.benchmark.datastructure.list.HLinkedList;
import name.hanyi.benchmark.datastructure.list.HSynchronizedArrayList;
import name.hanyi.benchmark.datastructure.list.HVector;
import name.hanyi.benchmark.datastructure.map.HConcurrentHashMap;
import name.hanyi.benchmark.datastructure.map.HHashMap;
import name.hanyi.benchmark.datastructure.map.HIdentityHashMap;
import name.hanyi.benchmark.datastructure.map.HLinkedHashMap;
import name.hanyi.benchmark.datastructure.map.HSynchronizedHashMap;
import name.hanyi.benchmark.datastructure.map.HTreeMap;
import name.hanyi.benchmark.datastructure.map.HWeakHashMap;
import name.hanyi.benchmark.datastructure.queue.HArrayBlockingQueue;
import name.hanyi.benchmark.datastructure.queue.HLinkedBlockingQueue;
import name.hanyi.benchmark.datastructure.queue.HPriorityQueue;
import name.hanyi.benchmark.datastructure.queue.HLinkedTransferQueue;
import name.hanyi.benchmark.datastructure.set.HHashSet;
import name.hanyi.benchmark.datastructure.set.HLinkedHashSet;
import name.hanyi.benchmark.datastructure.set.HSynchronizedHashSet;
import name.hanyi.benchmark.datastructure.set.HTreeSet;

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
            new HHashSet<>(),
            new HTreeSet<>(),
            new HLinkedHashSet<>(),
//            new HCopyOnWriteArraySet<>()
            new HHashMap<>(),
            new HTreeMap<>(),
            new HLinkedHashMap<>(),
            new HWeakHashMap<>(),
            new HIdentityHashMap<>(),
            new HConcurrentHashMap<>(),
            new HLinkedBlockingQueue<>(),
            new HArrayBlockingQueue<>(),
            new HPriorityQueue<>(),
            new HLinkedTransferQueue<>(),
            new HArrayDeque<>(),
            new HLinkedBlockingDeque<>(),
            new HSynchronizedHashSet<>(),
            new HSynchronizedArrayList<>(),
            new HSynchronizedHashMap<>()
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
