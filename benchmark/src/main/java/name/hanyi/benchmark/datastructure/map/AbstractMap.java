package name.hanyi.benchmark.datastructure.map;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class AbstractMap<E> implements BaseDataStructure<E> {

    protected Map<E, Integer> list;

    protected AbstractMap(Map<E, Integer> list) {
        this.list = list;
    }

    @Override
    public void add(E line) {
        list.put(line, 1);
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
        targetList.forEach(t -> this.list.remove(t));
    }

    @Override
    public Stream<E> reduce(Function<E, E> fn) {
        return list.entrySet()
                .stream()
                .map(e -> fn.apply(e.getKey()));
    }

    @Override
    public Stream<E> parallel(Function<E, E> fn) {
        return list.entrySet()
                .parallelStream()
                .map(e -> fn.apply(e.getKey()));
    }
}
