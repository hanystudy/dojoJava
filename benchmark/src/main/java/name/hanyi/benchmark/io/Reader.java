package name.hanyi.benchmark.io;

import name.hanyi.benchmark.datastructure.BaseDataStructure;

import java.io.IOException;

public interface Reader<E> {
    void read(BaseDataStructure<E> dataStructure) throws IOException;
}
