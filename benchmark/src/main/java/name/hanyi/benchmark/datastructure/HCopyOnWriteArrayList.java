package name.hanyi.benchmark.datastructure;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HCopyOnWriteArrayList<E> implements BaseDataStructure<E> {

    private List<E> list = new CopyOnWriteArrayList<>();

    @Override
    public void add(E line) {
        list.add(line);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String getName() {
        return "CopyOnWriteArrayList";
    }
}
