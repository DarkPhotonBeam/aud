package com.danphoton.structures.graph;


import java.util.*;

import com.danphoton.structures.heap.MinHeap;
import com.danphoton.structures.queue.Queue;
import com.danphoton.structures.set.UnionFind;

public class Graph<T> {

    protected HashMap<T, HashSet<T>> adj;
    protected HashMap<T, HashMap<T, Integer>> weights;
    protected int numEdges;
    protected LinkedList<T> vertices;
    protected ArrayList<WeightedEdge<T>> weightedEdges;
    protected boolean directed;

    public Graph() {
        adj = new HashMap<>();
        numEdges = 0;
        vertices = new LinkedList<>();
        directed = false;
        weights = new HashMap<>();
        weightedEdges = new ArrayList<>();
    }

    public Graph(boolean directed) {
        adj = new HashMap<>();
        numEdges = 0;
        vertices = new LinkedList<>();
        this.directed = directed;
        weights = new HashMap<>();
        weightedEdges = new ArrayList<>();
    }

    public void addVertex(T u) {
        if (!adj.containsKey(u)) {
            adj.put(u, new HashSet<>());
            vertices.add(u);
            weights.put(u, new HashMap<>());
        }
    }

    public int getNumEdges() {
        return numEdges;
    }

    public int getNumVertices() {
        return vertices.size();
    }

    public void addEdge(T u, T v, int weight) {
        addVertex(u);
        addVertex(v);
        adj.get(u).add(v);
        if (!weights.get(u).containsKey(v)) weightedEdges.add(new WeightedEdge<>(u, v, weight));
        weights.get(u).put(v, weight);
        if (!directed) {
            adj.get(v).add(u);
            weights.get(v).put(u, weight);
        }
        numEdges++;
    }

    public void addEdge(T u, T v) {
        addEdge(u, v, 0);
    }

    public DijkstraResult<T> Dijkstra(T s) {
        DijkstraResult<T> res = new DijkstraResult<>();
        MinHeap<WeightedVertex<T>> priorityQueue = new MinHeap<>();
        HashSet<T> unvisited = new HashSet<>();
        for (T u : vertices) {
            res.setDist(u, Integer.MAX_VALUE);
            res.setPrev(u, null);
            unvisited.add(u);
        }
        res.setDist(s, 0);
        priorityQueue.insert(new WeightedVertex<>(s, res.getDist(s)));
        unvisited.remove(s);

        while (!priorityQueue.isEmpty()) {
            T u = priorityQueue.extractMin().key;
            unvisited.remove(u);

            for (T v : adj.get(u)) {
                if (!unvisited.contains(v)) continue;

                int alt = res.getDist(u) + weights.get(u).get(v);
                if (alt < res.getDist(v)) {
                    res.setDist(v, alt);
                    res.setPrev(v, u);
                    priorityQueue.insert(new WeightedVertex<>(v, res.getDist(v)));
                    System.out.println(u + "/" + v + " +");
                } else {
                    System.out.println(u + "/" + v);
                }
            }
        }

        return res;
    }

    public void Dijkstra() {
        // TODO
    }

    public void BellmanFord() {
        // TODO
    }

    public Graph<T> Kruskal() {
        MinHeap<WeightedEdge<T>> minHeap = new MinHeap<>();
        for (WeightedEdge<T> weightedEdge : weightedEdges) {
            minHeap.insert(weightedEdge);
        }
        UnionFind<T> unionFind =  new UnionFind<>();
        for (T vertex : vertices) {
            unionFind.makeSet(vertex);
        }
        Graph<T> tree = new Graph<>();
        while (!minHeap.isEmpty()) {
            WeightedEdge<T> edge = minHeap.extractMin();
            T rootA = unionFind.find(edge.u);
            T rootB = unionFind.find(edge.v);
            if ((rootA == null || rootB == null) || (!rootA.equals(rootB))) {
                tree.addEdge(edge.u, edge.v, edge.weight);
                unionFind.union(edge.u, edge.v);
            }
        }
        return tree;
    }

    public void DFS(T s, DFSResult<T> dfsResult) {

    }

    public void BFS(T s, BFSResult<T> bfsResult) {
        Queue<T> queue = new Queue<>();
        queue.enqueue(s);
        bfsResult.setDist(s, 0);
        bfsResult.putEnter(s);
        while (!queue.isEmpty()) {
            T u = queue.dequeue();
            bfsResult.putLeave(u);
            for (T v : adj.get(u)) {
                if (!bfsResult.isVisited(v)) {
                    queue.enqueue(v);
                    bfsResult.putEnter(v);
                    bfsResult.setDist(v, u);
                }
            }
        }
    }

    public BFSResult<T> BFS(T s) {
        BFSResult<T> bfsResult = new BFSResult<>();
        BFS(s, bfsResult);
        return bfsResult;
    }

    public BFSResult<T> BFS() {
        BFSResult<T> bfsResult = new BFSResult<>();
        for (T u : vertices) {
            if (!bfsResult.isVisited(u)) BFS(u, bfsResult);
        }
        return bfsResult;
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (WeightedEdge<T> weightedEdge : weightedEdges) {
            totalWeight += weightedEdge.weight;
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adj=" + adj +
                ", weights=" + weights +
                ", numEdges=" + numEdges +
                ", vertices=" + vertices +
                ", weightedEdges=" + weightedEdges +
                ", directed=" + directed +
                '}';
    }
}
