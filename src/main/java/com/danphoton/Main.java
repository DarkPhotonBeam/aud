package com.danphoton;

import com.danphoton.structures.graph.BFSResult;
import com.danphoton.structures.graph.DijkstraResult;
import com.danphoton.structures.graph.Graph;
import com.danphoton.structures.heap.MinHeap;

public class Main {
    public static void main(String[] args) {
        //bfs();
        //minHeap();
        dijkstra();
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