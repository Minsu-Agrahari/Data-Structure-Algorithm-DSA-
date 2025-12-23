package NonLineal_DSA.Graph.Topological_Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* ---------------- Grap Class ---------------- */
class Graph {

    int vertex;
    List<List<Integer>> graph;

    public Graph(int vertex) {
        this.vertex = vertex;
        this.graph = new ArrayList<>();

        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // add directed edge
    void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    // DFS display
    void display(int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + " ");

        for (int v : graph.get(src)) {
            if (!visited[v]) {
                display(v, visited);
            }
        }
    }

    // DFS-based Topological Sort
    void topologicalSorting(int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;

        for (int v : graph.get(src)) {
            if (!visited[v]) {
                topologicalSorting(v, visited, st);
            }
        }

        // push after visiting all neighbours
        st.push(src);
    }
}

/* ---------------- Driver Class ---------------- */
public class TopologicalSorting {

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.print("DFS Traversal from 4: ");
        g.display(4, new boolean[6]);

        boolean[] visited = new boolean[g.vertex];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < g.vertex; i++) {
            if (!visited[i]) {
                g.topologicalSorting(i, visited, st);
            }
        }

        System.out.print("\nTopological Sorting: ");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}
