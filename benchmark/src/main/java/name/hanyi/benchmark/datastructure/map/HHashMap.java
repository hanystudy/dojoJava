package name.hanyi.benchmark.datastructure.map;

import java.util.HashMap;

public class HHashMap<E> extends AbstractMap<E> {

    public HHashMap() {
        super(new HashMap<>());
    }

    @Override
    public String getName() {
        return "HashMap";
    }
}