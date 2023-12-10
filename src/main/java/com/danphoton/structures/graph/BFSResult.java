package com.danphoton.structures.graph;

import java.util.HashMap;

public class BFSResult<T> {
    private final HashMap<T, Integer> dist;
    private final HashMap<T, Integer> enter;
    private final HashMap<T, Integer> leave;
    private int t;

    public BFSResult() {
        dist = new HashMap<>();
        enter = new HashMap<>();
        leave = new HashMap<>();
        t = 0;
    }

    public BFSResult(int initialT) {
        dist = new HashMap<>();
        enter = new HashMap<>();
        leave = new HashMap<>();
        t = initialT;
    }

    public void putEnter(T u) {
        enter.put(u, t);
        ++t;
    }

    public void putLeave(T u) {
        leave.put(u, t);
        ++t;
    }

    public void setDist(T u, int value) {
        dist.put(u, value);
    }

    public void setDist(T u, T v) {
        dist.put(u, dist.get(v)+1);
    }

    public boolean isVisited(T u) {
        return enter.containsKey(u);
    }

    public HashMap<T, Integer> getEnter() {
        return enter;
    }

    public HashMap<T, Integer> getLeave() {
        return leave;
    }

    public HashMap<T, Integer> getDist() {
        return dist;
    }

    @Override
    public String toString() {
        return "BFSResult{" +
                "dist=" + dist +
                ", enter=" + enter +
                ", leave=" + leave +
                ", t=" + t +
                '}';
    }
}
