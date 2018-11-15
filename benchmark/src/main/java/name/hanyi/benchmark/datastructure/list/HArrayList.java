package name.hanyi.benchmark.datastructure.list;

import java.util.ArrayList;

public class HArrayList<E> extends AbstractList<E> {

    public HArrayList() {
        super(new ArrayList<>());
    }

    @Override
    public String getName() {
        return "ArrayList";
    }
}
