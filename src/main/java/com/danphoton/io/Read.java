package com.danphoton.io;

import com.danphoton.structures.graph.Graph;

import java.io.File;
import java.util.Scanner;

public class Read {

    public static Graph<Integer> readGraph(String path) {
        try {
            Scanner s = new Scanner(new File(path));
            int m = s.nextInt();
            boolean directed = s.nextBoolean();
            boolean weighted = s.nextBoolean();
            Graph<Integer> g = new Graph<>(directed);
            for (int i = 0; i < m; i++) {
                int u = s.nextInt();
                int v = s.nextInt();
                if (weighted) {
                    g.addEdge(u, v, s.nextInt());
                } else {
                    g.addEdge(u, v);
                }
            }
            return g;
        } catch (Exception e) {
            return null;
        }
    }

}
