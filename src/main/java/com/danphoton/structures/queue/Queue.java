package com.danphoton.structures.queue;

import com.danphoton.structures.linkedlist.LinkedList;

import java.util.Collection;
import java.util.Iterator;

public class Queue<T> {

    LinkedList<T> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void enqueue(T value) {
        queue.addLast(value);
    }

    public T dequeue() {
        return queue.removeFirst();
    }

    public T peek() {
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
