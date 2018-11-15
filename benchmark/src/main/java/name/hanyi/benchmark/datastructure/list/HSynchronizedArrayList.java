package name.hanyi.benchmark.datastructure.list;

import java.util.ArrayList;
import java.util.Collections;

public class HSynchronizedArrayList<E> extends AbstractList<E> {

    public HSynchronizedArrayList() {
        super(Collections.synchronizedList(new ArrayList<>()));
    }

    @Override
    public String getName() {
        return "Synchronized ArrayList";
    }
}
