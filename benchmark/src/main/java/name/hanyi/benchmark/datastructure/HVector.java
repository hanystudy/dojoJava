package name.hanyi.benchmark.datastructure;

import java.util.List;
import java.util.Vector;

public class HVector<E> implements BaseDataStructure<E> {

    private List<E> list = new Vector<>();

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
        return "Vector";
    }
}
