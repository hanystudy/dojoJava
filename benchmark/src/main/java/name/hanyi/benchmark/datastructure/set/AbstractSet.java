package name.hanyi.benchmark.datastructure.set;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public Map<E, List<E>> groupBy(UnaryOperator<E> fn) {
        return list.parallelStream()
                .collect(Collectors.groupingByConcurrent(fn));
    }

    @Override
    public List<E> sort(Comparator<E> comparator) {
        List<E> newList = list.stream().collect(Collectors.toList());
        Collections.sort(newList, comparator);
        return newList;
    }

    @Override
    public List<E> shuffle(Random random) {
        List<E> newList = list.stream().collect(Collectors.toList());
        Collections.shuffle(newList, random);
        return newList;
    }

    @Override
    public int search(E e, Comparator<E> comparator) {
        List<E> newList = list.stream().collect(Collectors.toList());
        return Collections.binarySearch(newList, e, comparator);
    }
}