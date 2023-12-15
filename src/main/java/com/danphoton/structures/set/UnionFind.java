package com.danphoton.structures.set;

import java.util.*;

public class UnionFind<T> {

    private final HashMap<T, T> parent = new HashMap<>();
    private final HashMap<T, Integer> rank = new HashMap<>();
    private int size = 0;
    private int numberOfPartitions = 0;

    public void makeSet(T key) {
        if (!rank.containsKey(key)) {
            parent.put(key, null);
            rank.put(key, 0);
            ++size;
            ++numberOfPartitions;
        }
    }

    public T find(T key) {
        if (!rank.containsKey(key)) return null;
        if (parent.get(key) != null && !parent.get(key).equals(key)) {
            parent.put(key, find(parent.get(key)));
            return parent.get(key);
        } else {
            return key;
        }
    }

    public void union(T a, T b) {
        T rootA = find(a);
        T rootB = find(b);
        if (rootA == null || rootB == null) return;
        T root;
        T toBeMerged;
        if (rank.get(rootA) < rank.get(rootB)) {
            root = rootB;
            toBeMerged = rootA;
        } else {
            root = rootA;
            toBeMerged = rootB;
        }
        parent.put(toBeMerged, root);
        --numberOfPartitions;
        if (Objects.equals(rank.get(rootA), rank.get(rootB))) {
            rank.put(root, rank.get(root)+1);
        }
    }

    public boolean contains(T key) {
        return rank.containsKey(key);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getNumberOfPartitions() {
        return numberOfPartitions;
    }

    public void printRoots() {
        for (Map.Entry<T, Integer> entry : rank.entrySet()) {
            System.out.println(entry.getKey() + " <- " + find(entry.getKey()));
        }
    }

    @Override
    public String toString() {
        return "UnionFind{" +
                "parent=" + parent +
                ", rank=" + rank +
                ", size=" + size +
                ", numberOfPartitions=" + numberOfPartitions +
                '}';
    }
}
