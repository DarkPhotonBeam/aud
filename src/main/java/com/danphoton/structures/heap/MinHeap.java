package com.danphoton.structures.heap;

import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {
    protected int size;
    protected ArrayList<T> heap;

    public MinHeap() {
        size = 0;
        heap = new ArrayList<>();
    }

    public MinHeap(T[] arr) {
        heap = new ArrayList<>(Arrays.asList(arr));
        size = arr.length;
        createHeap();
    }

    public T findMin() {
        return isEmpty() ? null : heap.get(0);
    }

    public T peek() {
        return findMin();
    }

    public void insert(T value) {
        heap.add(value);
        ++size;
        siftUp(size-1);
    }

    public void push(T value) {
        insert(value);
    }

    public T extractMin() {
        if (isEmpty()) return null;
        T value = getNode(0);
        swap(0, size-1);
        heap.remove(size-1);
        --size;
        if (size > 1) siftDown(0);
        return value;
    }

    public T pop() {
        return extractMin();
    }

    public void deleteMin() {
        extractMin();
    }

    public void replace(int index, T value) {
        T prevValue = heap.get(index);
        heap.set(index, value);
        if (prevValue.compareTo(value) > 0) {
            siftUp(index);
        } else {
            siftDown(index);
        }
    }

    public void createHeap() {
        for (int i = size / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void delete(int index) {
        if (size == 0) return;
        if (size == 1) {
            heap.clear();
            return;
        }
        swap(index, size-1);
        siftUp(index);
        siftDown(index);
        heap.remove(size-1);
        --size;
    }

    protected void siftUp(int index) {
        int i = index;
        while (i > 0 && getNode(i).compareTo(getParent(i)) < 0) {
            int parentIndex = getParentIndex(i);
            swap(i, parentIndex);
            i = parentIndex;
        }
    }

    protected void siftDown(int index) {
        int i = index;
        while (i*2+1 < size) {
            int newIndex = 0;
            if (getNode(i).compareTo(getLeft(i)) > 0 && (i*2 + 2 >= size || getLeft(i).compareTo(getRight(i)) < 0)) {
                newIndex = getLeftIndex(i);
            } else if (i*2 + 2 < size && getNode(i).compareTo(getRight(i)) > 0) {
                newIndex = getRightIndex(i);
            } else break;
            swap(i, newIndex);
            i = newIndex;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    private T getNode(int index) {
        return heap.get(index);
    }

    private int getParentIndex(int index) {
        int parentIndex = (index-1)/2;
        if (parentIndex >= size || index < 0) throw new ArrayIndexOutOfBoundsException();
        return parentIndex;
    }

    private int getLeftIndex(int index) {
        if (index * 2 + 1 >= size || index < 0) throw new ArrayIndexOutOfBoundsException();
        return index * 2 + 1;
    }

    private int getRightIndex(int index) {
        if (index * 2 + 2 >= size || index < 0) throw new ArrayIndexOutOfBoundsException();
        return index * 2 + 2;
    }

    private T getParent(int index) {
        return heap.get(getParentIndex(index));
    }

    private T getLeft(int index) {
        return heap.get(getLeftIndex(index));
    }

    private T getRight(int index) {
        return heap.get(getRightIndex(index));
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "size=" + size +
                ", heap=" + heap +
                '}';
    }
}
