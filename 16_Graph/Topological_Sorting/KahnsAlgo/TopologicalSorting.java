package NonLineal_DSA.Graph.Topological_Sorting.KahnsAlgo;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class TopologicalSorting {
    static class Graph{
        int vertex;
        List<List<Integer>> graph;

        Graph(int vertex){
            this.vertex = vertex;
            graph = new ArrayList<>();

            for (int i=0; i<vertex; i++){
                graph.add(new ArrayList<>());
            }
        }

        // Add Vertex
        void addEdge(int u, int v){
            graph.get(u).add(v);
        }

        // Khan's Algo
        void khansAlgo(){
            int[] indegree = new int[vertex];

            // step 1: Calculate indegree of each vertex
            for(int u = 0; u < vertex; u++){
                for(int v : graph.get(u)){
                    indegree[v]++;
                }
            }

            // step 2: Add all vertices with indegree 0 to queue
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<vertex; i++){
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }

            // step 3: BFS
            int count = 0;
            List<Integer> topologicalOrder = new ArrayList<>();

            while(!q.isEmpty()){
                int node = q.poll();
                topologicalOrder.add(node);
                count++;

                for(int neighbor : graph.get(node)){
                    indegree[neighbor]--;

                    if(indegree[neighbor] == 0){
                        q.offer(neighbor);
                    }
                }
            }

            // step 4: Cycle detection
            if(count != vertex){
                System.out.println("Cycle detected! Topological sort not possible");
                return;
            }

            // Print result
            System.out.print("Topological Sorting (Khan's Algo): ");
            for(int val : topologicalOrder){
                System.out.print(val + " ");
            }
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(5, 0);
        g.addEdge(5, 2);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.khansAlgo();
    }
}
