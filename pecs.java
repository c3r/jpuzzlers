public class Stack<E> { 
    public Stack(); 
    public void push(E e); 
    public E pop(); 
    public boolean isEmpty(); 

    public void pushAll(Iterable<E> src) { 
        for (E e : src) 
            push(e); 
    }

    public void popAll(Collection<E> dst) { 
        while (!isEmpty()) 
            dst.add(pop()); 
    }
}

(...)

Stack<Number> numberStack = new Stack<Number>(); 
Iterable<Integer> integers = ... ; 
numberStack.pushAll(integers);

Stack<Number> numberStack = new Stack<Number>(); 
Collection<Object> objects = ... ; 
numberStack.popAll(objects);

