package name.hanyi.benchmark.datastructure.set;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.util.Collection;
import java.util.Set;

public abstract class AbstractSet<E> implements BaseDataStructure<E> {

    protected Set<E> list;

    protected AbstractSet(Set<E> list) {
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