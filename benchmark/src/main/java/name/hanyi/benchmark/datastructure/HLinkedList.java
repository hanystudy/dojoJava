package name.hanyi.benchmark.datastructure;

import java.util.LinkedList;
import java.util.List;

public class HLinkedList<E> implements BaseDataStructure<E> {

    private List<E> list = new LinkedList<>();

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
        return "LinkedList";
    }
}
