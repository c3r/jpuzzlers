package pecs;

import java.util.ArrayList;
import java.util.List;

public class PECS2 {

    private final static int N = 30;

    private static final Function<Number> MAX = (n1, n2) -> Double.compare(n1.doubleValue(), n2.doubleValue()) > 0
            ? n1
            : n2;

    private static final Function<Integer> ADD = (d1, d2) -> d1 + d2;


    public static void main(String[] args) {

        // Create an integer list and reduce it
        // -------------------------------------------------------------------------------------------------------------
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(i);
        }

        System.out.println(reduce(list, ADD, 0));
        System.out.println(reduce(list, MAX, 0));

        // xxx
        // -------------------------------------------------------------------------------------------------------------
    }

    interface Function<T> {
        T apply(T a1, T a2);
    }

    static <E> E reduce(List<? extends E> list, Function<E> function, E initVal) {
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<>(list);
        }
        E result = initVal;
        for (E e : snapshot) {
            result = function.apply(e, result);
        }
        return result;

    }

}
