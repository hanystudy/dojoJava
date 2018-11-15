package name.hanyi.benchmark.datastructure.set;

import java.util.Collections;
import java.util.HashSet;

public class HSynchronizedHashSet<E> extends AbstractSet<E> {

    public HSynchronizedHashSet() {
        super(Collections.synchronizedSet(new HashSet<>()));
    }

    @Override
    public String getName() {
        return "Synchronized HashSet";
    }
}