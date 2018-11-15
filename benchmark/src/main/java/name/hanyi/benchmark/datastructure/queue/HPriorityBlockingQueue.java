package name.hanyi.benchmark.datastructure.queue;

import java.util.concurrent.PriorityBlockingQueue;

public class HPriorityBlockingQueue<E> extends AbstractQueue<E> {

    public HPriorityBlockingQueue() {
        super(new PriorityBlockingQueue<>());
    }

    @Override
    public String getName() {
        return "PriorityBlockingQueue";
    }
}