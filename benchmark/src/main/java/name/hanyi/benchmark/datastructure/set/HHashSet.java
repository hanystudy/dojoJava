package name.hanyi.benchmark.datastructure.set;

import java.util.HashSet;

public class HHashSet<E> extends AbstractSet<E> {

    public HHashSet() {
        super(new HashSet<>());
    }

    @Override
    public String getName() {
        return "HashSet";
    }
}