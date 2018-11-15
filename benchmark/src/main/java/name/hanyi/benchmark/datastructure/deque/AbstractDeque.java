package name.hanyi.benchmark.datastructure.deque;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.util.Collection;
import java.util.Deque;

public abstract class AbstractDeque<E> implements BaseDataStructure<E> {

    protected Deque<E> list;

    protected AbstractDeque(Deque<E> list) {
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
    public void removeAll(Collection<E> targetList) {
        this.list.removeAll(targetList);
    }
}
