package name.hanyi.benchmark.datastructure.list;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

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

    @Override
    public Stream<E> reduce(Function<E, E> fn) {
        return list.stream()
                .map(e -> fn.apply(e));
    }

    @Override
    public Stream<E> parallel(Function<E, E> fn) {
        return list.parallelStream()
                .map(e -> fn.apply(e));
    }
}