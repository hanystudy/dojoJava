package name.hanyi.benchmark.datastructure.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class HLinkedBlockingQueue<E> extends AbstractQueue<E> {

    public HLinkedBlockingQueue() {
        super(new LinkedBlockingQueue<>());
    }

    @Override
    public String getName() {
        return "LinkedBlockingQueue";
    }
}