package name.hanyi.benchmark.datastructure.queue;

import java.util.PriorityQueue;

public class HPriorityQueue<E> extends AbstractQueue<E> {

    public HPriorityQueue() {
        super(new PriorityQueue<>());
    }

    @Override
    public String getName() {
        return "PriorityQueue";
    }
}