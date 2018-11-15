package name.hanyi.benchmark.datastructure.map;

import java.util.TreeMap;

public class HTreeMap<E> extends AbstractMap<E> {

    public HTreeMap() {
        super(new TreeMap<>());
    }

    @Override
    public String getName() {
        return "TreeMap";
    }
}
