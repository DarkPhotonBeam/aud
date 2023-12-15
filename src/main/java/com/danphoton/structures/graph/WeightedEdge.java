package com.danphoton.structures.graph;

public class WeightedEdge<T> implements Comparable<WeightedEdge<T>> {
    T u;
    T v;
    int weight;

    public WeightedEdge(T u, T v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge<T> o) {
        return weight - o.weight;
    }

    @Override
    public String toString() {
        return "WeightedEdge{" +
                "u=" + u +
                ", v=" + v +
                ", weight=" + weight +
                '}';
    }
}
