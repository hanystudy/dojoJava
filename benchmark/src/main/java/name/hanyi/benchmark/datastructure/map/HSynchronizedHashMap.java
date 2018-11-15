package name.hanyi.benchmark.datastructure.map;

import java.util.Collections;
import java.util.HashMap;

public class HSynchronizedHashMap<E> extends AbstractMap<E> {

    public HSynchronizedHashMap() {
        super(Collections.synchronizedMap(new HashMap<>()));
    }

    @Override
    public String getName() {
        return "Synchronized HashMap";
    }
}
