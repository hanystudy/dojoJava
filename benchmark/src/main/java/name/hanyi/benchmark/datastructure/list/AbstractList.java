package name.hanyi.benchmark.datastructure.list;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.util.Collection;
import java.util.List;

public abstract class AbstractList<E> implements BaseDataStructure<E> {

    protected List<E> list;

    protected AbstractList(List<E> list) {
        this.list = list;
    }

    @Override
    public void add(E line) {
        list.add(line);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void removeAll(Collection<E> list) {
        this.list.removeAll(list);
    }
}