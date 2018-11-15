package name.hanyi.benchmark.datastructure.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class HArrayBlockingQueue<E> extends AbstractQueue<E> {

    public static final int DEFAULT_CAPACITY = 100000;

    public HArrayBlockingQueue() {
        super(new ArrayBlockingQueue<>(DEFAULT_CAPACITY));
    }

    @Override
    public String getName() {
        return "ArrayBlockingQueue";
    }
}