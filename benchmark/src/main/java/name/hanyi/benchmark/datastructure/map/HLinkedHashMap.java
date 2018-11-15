package name.hanyi.benchmark.datastructure.map;

import java.util.LinkedHashMap;

public class HLinkedHashMap<E> extends AbstractMap<E> {

    public HLinkedHashMap() {
        super(new LinkedHashMap<>());
    }

    @Override
    public String getName() {
        return "LinkedHashMap";
    }
}