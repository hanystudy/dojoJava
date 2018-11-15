package name.hanyi.benchmark.datastructure.list;

import java.util.concurrent.CopyOnWriteArrayList;

public class HCopyOnWriteArrayList<E> extends AbstractList<E> {

    public HCopyOnWriteArrayList() {
        super(new CopyOnWriteArrayList<>());
    }

    @Override
    public String getName() {
        return "CopyOnWriteArrayList";
    }
}
