package name.hanyi.benchmark.datastructure;

public interface BaseDataStructure<E> {
    void add(E line);

    int size();

    String getName();
}
