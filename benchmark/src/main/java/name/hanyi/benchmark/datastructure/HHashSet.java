package name.hanyi.benchmark.datastructure;

import java.util.HashSet;
import java.util.Set;

public class HHashSet<E> implements BaseDataStructure<E> {

    private Set<E> list = new HashSet<>();

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
        return "HashSet";
    }
}
