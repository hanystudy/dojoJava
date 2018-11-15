package name.hanyi.benchmark.datastructure.map;

import java.util.WeakHashMap;

public class HWeakHashMap<E> extends AbstractMap<E> {

    public HWeakHashMap() {
        super(new WeakHashMap<>());
    }

    @Override
    public String getName() {
        return "WeakHashMap";
    }
}
