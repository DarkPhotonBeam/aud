package com.danphoton;

import com.danphoton.io.Read;
import com.danphoton.structures.graph.BFSResult;
import com.danphoton.structures.graph.DijkstraResult;
import com.danphoton.structures.graph.Graph;
import com.danphoton.structures.heap.MinHeap;
import com.danphoton.structures.set.UnionFind;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        bfs();
        minHeap();
        dijkstra();
        //ben();
        kruskal();
    }

    public static void kruskal() {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 3, 4);

        g.addEdge(4, 5, 3);
        g.addEdge(4, 6, 1);
        g.addEdge(5, 6, 2);
        Graph<Integer> mst = g.Kruskal();
        System.out.println(mst.toString());
        System.out.println(mst.getTotalWeight());
    }

    public static void unionFindTest() {
        UnionFind<Integer> u = new UnionFind<>();

        u.makeSet(1);
        u.makeSet(2);
        u.makeSet(3);
        u.makeSet(4);
        u.makeSet(5);
        System.out.println(u.getNumberOfPartitions());
        u.union(1, 2);
        System.out.println(u.getNumberOfPartitions());
        u.union(3, 4);
        u.union(4, 5);
        System.out.println(u.getNumberOfPartitions());
        u.printRoots();
        System.out.println(u.toString());
        u.union(5, 1);
        u.printRoots();
        System.out.println(u.toString());
    }

    public static void ben() {
        Graph<Integer> g = Read.readGraph("input/input2.txt");
        if (g == null) {
            System.out.println("File not found");
            return;
        }
        System.out.println(g.getNumEdges());
        System.out.println(g.getNumVertices());
        DijkstraResult<Integer> result = g.Dijkstra(1);
        System.out.println(result.toString());
        DijkstraResult<Integer> result2 = g.Dijkstra(5);
        System.out.println(result2.toString());
    }

    public static void bfs() {
        Graph<Integer> g = new Graph<>(true);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 1);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(5, 6);
        g.addEdge(6, 0);
        g.addEdge(7, 8);

        BFSResult<Integer> bfs = g.BFS();
        System.out.println(bfs.toString());
    }

    public static void dijkstra() {
        Graph<Integer> g = new Graph<>(true);

        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 3);
        g.addEdge(0, 3, 7);
        g.addEdge(2, 3, 2);
        g.addEdge(1, 4, 5);
        g.addEdge(4, 2, 1);
        g.addEdge(2, 5, 3);
        g.addEdge(2, 6, 19);
        g.addEdge(5, 6, 4);
        g.addEdge(1, 7, 20);
        g.addEdge(3, 7, 9);

        DijkstraResult<Integer> res = g.Dijkstra(0);
        System.out.println(res.toString());
    }

    public static void minHeap() {
        MinHeap<Integer> heap = new MinHeap<>(new Integer[]{20, 12, 42, 12042, 13, 0, -13, 324, 4, 563, 52, 24, 1, 4, 63, 2, 8});
        System.out.println(heap.toString());



        heap.replace(4, 1301301);

        int n = heap.size();

        for (int i = 0; i < n; i++) {
            System.out.println(heap.extractMin());
        }


        System.out.println(heap.toString());
    }
}