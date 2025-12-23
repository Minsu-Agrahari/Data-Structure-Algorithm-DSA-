package NonLineal_DSA.Graph.CycleDetection.GraphCreation;

import java.util.ArrayList;

public class unDir_unWt_graphCreation {

    static class Graph {
        int vertex;
        ArrayList<ArrayList<Integer>> graph;

        // inistalazing the vertex
        Graph(int vertex) {
            this.vertex = vertex;
            graph = new ArrayList<>();

            // initalizaing all the vertex with a new ArrayList<Integer>
            for(int i = 0; i<vertex; i++){
                graph.add(new ArrayList<>());
            }
        }



        // add edges in graph
        void addEdge(int u, int v) {
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // display graph
        void display() {
            for (int i = 0; i < vertex; i++) {
                System.out.println(i + " : " + graph.get(i));
            }
        }
    }

    public static void main(String[] args){
        int vertex = 5;
        Graph g = new Graph(vertex);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);

        g.display();
    }
}
