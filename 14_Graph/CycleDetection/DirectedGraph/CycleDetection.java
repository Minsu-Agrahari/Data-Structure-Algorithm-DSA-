package NonLineal_DSA.Graph.CycleDetection.DirectedGraph;

import java.util.List;
import java.util.ArrayList;

public class CycleDetection {

    static class Graph{
        int vertex;
        List<List<Integer>> graph;

        Graph(int vertex) {
            this.vertex = vertex;
            this.graph = new ArrayList<>();

            for(int i=0; i<vertex; i++){
                graph.add(new ArrayList<>());
            }
        }
        // vertex in directed graph
        void addEdge(int u, int v){
            graph.get(u).add(v);
        }

        // dfs traversal
        void dfs_display(int src, boolean[] visited){
            System.out.print(src + " ");
            visited[src] = true;

            for(int v : graph.get(src)){
                if(!visited[v]){
                    dfs_display(v, visited);
                }
            }
        }

        // Cycle Detection
        boolean cycleDetection(int src, boolean[] visited, boolean[] recursivePath){

            visited[src] = true;
            recursivePath[src] = true;

            for(int v : graph.get(src)){
                if(!visited[v]){
                    if(cycleDetection(v, visited, recursivePath)) return true;
                }else if(visited[v] && recursivePath[v]){
                    return true;
                }
            }

            recursivePath[src] = false;

            return false;
        }
    }

    static void main(String[] args) {
        Graph g = new Graph(5);

        // Cycle Present !!
//        g.addEdge(1, 0);
//        g.addEdge(0, 2);
//        g.addEdge(2, 3);
//        g.addEdge(3, 0);

        // Cycle Not Present !!
        g.addEdge(1,0);
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(0,3);

        g.dfs_display(1, new boolean[5]);
        System.out.println(g.cycleDetection(0, new boolean[5], new boolean[5]));
    }
}
