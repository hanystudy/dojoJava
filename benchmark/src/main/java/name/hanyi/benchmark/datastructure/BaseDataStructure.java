package name.hanyi.benchmark.datastructure;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public interface BaseDataStructure<E> {
    void add(E line);

    void clear();

    int size();

    String getName();

    void removeAll(Collection<E> targetList);

    Stream<E> reduce(Function<E, E> fn);

    Stream<E> parallel(Function<E, E> fn);

    Map<E, List<E>> groupBy(UnaryOperator<E> fn);

    List<E> sort(Comparator<E> comparator);

    List<E> shuffle(Random random);

    int search(E e, Comparator<E> comparator);
}
