package com.danphoton.structures.linkedlist;

public class LinkedNode<T> {

    T value;
    LinkedNode<T> prev;
    LinkedNode<T> next;

    public LinkedNode(T value) {
        this.value = value;
        prev = null;
        next = null;
    }
}
