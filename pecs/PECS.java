package pecs;


import java.util.ArrayList;
import java.util.Collection;

public class PECS {
    public static void main(String[] args) {

        Stack<Number> numberStack = new Stack<>();

        Iterable<Integer> integers = new ArrayList<>();
        Collection<Object> objects = new ArrayList<>();

        numberStack.pushAll(integers);
        numberStack.popAll(objects);
    }

    private static class Stack<E> {

        private ArrayList<E> list;

        void push(E e) {
            list.add(e);    // does not matter
        }

        E pop() {
            return list.get(0); // does not matter
        }

        boolean isEmpty() {
            return true;
        }

        void pushAll(Iterable<? extends E> src) {
            for (E e : src)
                push(e);
        }

        void popAll(Collection<? super E> dst) {
            while (!isEmpty())
                dst.add(pop());
        }
    }
}






