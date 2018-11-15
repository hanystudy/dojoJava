package name.hanyi.benchmark.datastructure.deque;

import java.util.ArrayDeque;

public class HArrayDeque<E> extends AbstractDeque<E> {

    public HArrayDeque() {
        super(new ArrayDeque<>());
    }

    @Override
    public String getName() {
        return "ArrayDeque";
    }
}
