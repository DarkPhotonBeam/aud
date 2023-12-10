package com.danphoton.structures.graph;

public class WeightedVertex<T> implements Comparable<WeightedVertex<T>> {
    T key;
    int weight;

    public WeightedVertex(T key, int weight) {
        this.key = key;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedVertex<T> o) {
        return weight - o.weight;
    }
}
