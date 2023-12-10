package com.danphoton.structures.linkedlist;

public class LinkedList<T> {

    protected LinkedNode<T> first;
    protected LinkedNode<T> last;
    protected int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void addLast(T value) {
        LinkedNode<T> newNode = new LinkedNode<>(value);
        if (size == 0) {
            last = newNode;
            first = newNode;
            ++size;
            return;
        }
        last.next = newNode;
        newNode.prev =  last;
        last = newNode;
        ++size;
    }

    public void add(T value) {
        addLast(value);
    }

    public void addFirst(T value) {
        LinkedNode<T> newNode = new LinkedNode<>(value);
        if (size == 0) {
            last = newNode;
            first = newNode;
            ++size;
            return;
        }
        newNode.next = first;
        first.prev = newNode;
        first = newNode;
        ++size;
    }

    public T removeLast() {
        if (size == 0) throw new IllegalArgumentException("Cannot remove item from empty list");
        if (size == 1) {
            T value = last.value;
            this.clear();
            return value;
        }
        T value = last.value;
        last.prev.next = null;
        last = last.prev;
        --size;
        return value;
    }

    public T removeFirst() {
        if (size == 0) throw new IllegalArgumentException("Cannot remove item from empty list");
        if (size == 1) {
            T value = first.value;
            this.clear();
            return value;
        }
        T value = first.value;
        first = first.next;
        first.prev = null;
        --size;
        return value;
    }

    public T getLast() {
        return last.value;
    }

    public T getFirst() {
        return first.value;
    }

    private LinkedNode<T> getNode(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index out of bounds");
        LinkedNode<T> node;
        if (index > size / 2) {
            node = last;
            int i = size-1;
            while (node.prev != null && index != i) {
                node = node.prev;
                --i;
            }

        } else {
            node = first;
            int i = 0;
            while (node.next != null && index != i) {
                node = node.next;
                ++i;
            }
        }
        return node;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public void set(int index, T value) {
        getNode(index).value = value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }
}
