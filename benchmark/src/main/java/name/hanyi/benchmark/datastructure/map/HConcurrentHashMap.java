package name.hanyi.benchmark.datastructure.map;

import java.util.concurrent.ConcurrentHashMap;

public class HConcurrentHashMap<E> extends AbstractMap<E> {

    public HConcurrentHashMap() {
        super(new ConcurrentHashMap<>());
    }

    @Override
    public String getName() {
        return "ConcurrentHashMap";
    }
}
