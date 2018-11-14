package name.hanyi.benchmark.datastructure;

import java.util.ArrayList;
import java.util.List;

public class HArrayList<E> implements BaseDataStructure<E> {

    private List<E> list = new ArrayList<>();

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
        return "ArrayList";
    }
}
