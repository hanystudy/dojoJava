package name.hanyi.benchmark.datastructure.set;

import java.util.LinkedHashSet;

public class HLinkedHashSet<E> extends AbstractSet<E> {

    public HLinkedHashSet() {
        super(new LinkedHashSet<>());
    }

    @Override
    public String getName() {
        return "LinkedHashSet";
    }
}