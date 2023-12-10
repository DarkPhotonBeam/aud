package com.danphoton.structures.graph;

import java.util.HashMap;

public class DijkstraResult<T> {

    private HashMap<T, Integer> dist;

    private HashMap<T, T> prev;

    public DijkstraResult() {
        dist = new HashMap<>();
        prev = new HashMap<>();
    }

    public void setDist(T key, int distance) {
        dist.put(key, distance);
    }

    public Integer getDist(T key) {
        return dist.get(key);
    }

    public void setPrev(T key, T prev) {
        this.prev.put(key, prev);
    }

    public HashMap<T, T> getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        return "DijkstraResult{" +
                "dist=" + dist +
                ", prev=" + prev +
                '}';
    }
}
