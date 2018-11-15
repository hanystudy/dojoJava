package name.hanyi.benchmark.datastructure;

import java.util.Collection;

public interface BaseDataStructure<E> {
    void add(E line);

    void clear();

    int size();

    String getName();

    void removeAll(Collection<E> targetList);
}
