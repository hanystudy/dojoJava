package name.hanyi.benchmark.datastructure.queue;

import java.util.concurrent.LinkedTransferQueue;

public class HLinkedTransferQueue<E> extends AbstractQueue<E> {

    public HLinkedTransferQueue() {
        super(new LinkedTransferQueue<>());
    }

    @Override
    public String getName() {
        return "LinkedTransferQueue";
    }
}