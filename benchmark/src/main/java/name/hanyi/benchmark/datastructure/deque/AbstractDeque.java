package name.hanyi.benchmark.datastructure.deque;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.util.Collection;
import java.util.Deque;
import java.util.function.Function;
import java.util.stream.Stream;

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
