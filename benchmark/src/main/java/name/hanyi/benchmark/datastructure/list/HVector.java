package name.hanyi.benchmark.datastructure.list;

import java.util.Vector;

public class HVector<E> extends AbstractList<E> {

    public HVector() {
        super(new Vector<>());
    }

    @Override
    public String getName() {
        return "Vector";
    }
}
