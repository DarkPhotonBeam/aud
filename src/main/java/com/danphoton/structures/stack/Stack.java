package com.danphoton.structures.stack;

import com.danphoton.structures.linkedlist.LinkedList;

public class Stack<T> {

    protected LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public void push(T value) {
        stack.addLast(value);
    }

    public T pop() {
        return stack.removeLast();
    }

    public T peek() {
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
