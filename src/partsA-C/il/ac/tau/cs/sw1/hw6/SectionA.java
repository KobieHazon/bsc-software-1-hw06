package il.ac.tau.cs.sw1.hw6;

import java.util.LinkedList;

/**
 * @inv !isEmpty() implies top() != null
 */
public class SectionA {
    private final LinkedList<Object> elements = new LinkedList<Object>();

    /**
     * @pre o != null
     * @post !isEmpty()
     * @post top() == o
     */
    public void push(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("null values are not allowed");
        }
        elements.add(o);
    }

    /**
     * @pre !isEmpty()
     * @post @return == top()@pre
     */
    public Object pop() {
        Object popped = top();
        elements.removeLast();
        return popped;
    }

    /**
     * @pre !isEmpty()
     * @post @return != null
     */
    public Object top() {
        return elements.getLast();
    }

    /**
     * @post @return == true iff elements.size() = 0
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
