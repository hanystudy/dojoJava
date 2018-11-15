package name.hanyi.benchmark.datastructure.deque;

import java.util.concurrent.LinkedBlockingDeque;

public class HLinkedBlockingDeque<E> extends AbstractDeque<E> {

    public HLinkedBlockingDeque() {
        super(new LinkedBlockingDeque<>());
    }

    @Override
    public String getName() {
        return "LinkedBlockingDeque";
    }
}