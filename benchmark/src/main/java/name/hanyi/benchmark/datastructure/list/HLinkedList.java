package name.hanyi.benchmark.datastructure.list;

import java.util.LinkedList;

public class HLinkedList<E> extends AbstractList<E> {

    public HLinkedList() {
        super(new LinkedList<>());
    }

    @Override
    public String getName() {
        return "LinkedList";
    }
}
