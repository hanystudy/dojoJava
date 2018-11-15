package name.hanyi.benchmark.datastructure.map;

import java.util.IdentityHashMap;

public class HIdentityHashMap<E> extends AbstractMap<E> {

    public HIdentityHashMap() {
        super(new IdentityHashMap<>());
    }

    @Override
    public String getName() {
        return "IdentityHashMap";
    }
}