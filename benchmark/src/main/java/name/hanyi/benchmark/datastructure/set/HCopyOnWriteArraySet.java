package name.hanyi.benchmark.datastructure.set;

import java.util.concurrent.CopyOnWriteArraySet;

public class HCopyOnWriteArraySet<E> extends AbstractSet<E> {

    public HCopyOnWriteArraySet() {
        super(new CopyOnWriteArraySet<>());
    }

    @Override
    public String getName() {
        return "CopyOnWriteArraySet";
    }
}