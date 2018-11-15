package name.hanyi.benchmark.datastructure;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;

public interface BaseDataStructure<E> {
    void add(E line);

    void clear();

    int size();

    String getName();

    void removeAll(Collection<E> targetList);

    Stream<E> reduce(Function<E, E> fn);

    Stream<E> parallel(Function<E, E> fn);
}
