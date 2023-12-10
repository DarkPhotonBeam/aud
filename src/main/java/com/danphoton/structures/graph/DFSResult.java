package com.danphoton.structures.graph;

import java.util.HashMap;

public class DFSResult<T> {

    private final HashMap<T, Integer> pre;

    private final HashMap<T, Integer> post;
    private int t;


    public DFSResult() {
        pre = new HashMap<>();
        post = new HashMap<>();
        t = 0;
    }

    public void putPre(T u) {
        pre.put(u, t);
        ++t;
    }

    public void putPost(T u) {
        post.put(u, t);
        ++t;
    }

    public HashMap<T, Integer> getPre() {
        return pre;
    }

    public HashMap<T, Integer> getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "DFSResult{" +
                "pre=" + pre +
                ", post=" + post +
                ", t=" + t +
                '}';
    }
}
