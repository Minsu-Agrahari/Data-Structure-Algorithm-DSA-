package NonLineal_DSA.Graph.Traversal.DFS;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class unDir_unWt_DFSTraversal {

    static class Graph {

        int vertex;
        List<List<Integer>> graph;

        Graph(int vertex) {
            this.vertex = vertex;
            graph = new ArrayList<>();

            for(int i=0; i<vertex; i++){
                graph.add(new ArrayList<>());
            }
        }

        void addVertex(int u, int v){
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        void display(){
            for(int i=0; i<vertex; i++){
                System.out.println(i + " : "+ graph.get(i));
            }
        }

        void dfs(int src, boolean[] visited){
            System.out.print(src + " ");
            visited[src] = true;

            for(int dis : graph.get(src)){
                if(!visited[dis]){
                    visited[dis] = true;
                    dfs(dis, visited);
                }
            }
        }
    }

    static void main(String[] args) {
        Graph g = new Graph(5);

        boolean[] visited = new boolean[5];
        Arrays.fill(visited, false);

        g.addVertex(0, 1);
        g.addVertex(1, 2);
        g.addVertex(1, 3);
        g.addVertex(2, 4);

        g.display();

        visited[0] = true;
        g.dfs(0, visited);
    }
}
