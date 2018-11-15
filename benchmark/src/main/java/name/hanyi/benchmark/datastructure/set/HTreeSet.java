package name.hanyi.benchmark.datastructure.set;

import java.util.TreeSet;

public class HTreeSet<E> extends AbstractSet<E> {

    public HTreeSet() {
        super(new TreeSet<>());
    }

    @Override
    public String getName() {
        return "TreeSet";
    }
}
