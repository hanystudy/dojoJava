package name.hanyi.benchmark.datastructure.queue;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.util.Collection;
import java.util.Queue;

public abstract class AbstractQueue<E> implements BaseDataStructure<E> {

    protected Queue<E> list;

    protected AbstractQueue(Queue<E> list) {
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