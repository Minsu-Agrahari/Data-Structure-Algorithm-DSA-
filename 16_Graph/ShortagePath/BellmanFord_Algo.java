package NonLineal_DSA.Graph.ShortagePath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BellmanFord_Algo {

    // Edge representation
    static class Pair{
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int[] bellmanFord(int vertex, List<List<Pair>> graph, int src){

        int [] dist = new int[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // step 1: Relax all edges (V-1) times
        for(int i=1; i<= vertex-1; i++){
            for(int u = 0; u < vertex; u++){

                if(dist[u] == Integer.MAX_VALUE) continue;

                for(Pair neighbor: graph.get(u)){
                    int v = neighbor.node;
                    int wt = neighbor.weight;

                    // Edge Relaxation
                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Step 2: Check for negative weight cycle
        // Why is a negative cycle a problem?
            //Because you can loop around the cycle again and again and keep reducing the path cost forever.
        // Bellman–Ford does NOT find the shortest paths when a negative cycle exists. It can only DETECT that a negative cycle exists.

        for(int u = 0; u< vertex; u++){
            if(dist[u] == Integer.MAX_VALUE) continue;

            for(Pair neighbor : graph.get(u)){
                int v = neighbor.node;
                int wt = neighbor.weight;

                if(dist[u] + wt < dist[v]){
                    System.out.println("Negative weight cycle detected");
                    return new int[0];
                }
            }
        }
        return dist;
    }

    // Driver Code
    static void main(String[] args) {
        int vertex = 5 ;
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }

        // Directed edges
        graph.get(0).add(new Pair(1, 6));
        graph.get(0).add(new Pair(2, 7));
        graph.get(1).add(new Pair(2, 8));
        graph.get(1).add(new Pair(3, 5));
        graph.get(1).add(new Pair(4, -4));
        graph.get(2).add(new Pair(3, -3));
        graph.get(2).add(new Pair(4, 9));
        graph.get(3).add(new Pair(1, -2));
        graph.get(4).add(new Pair(3, 7));

        int src = 0;
        int[] dist = bellmanFord(vertex, graph, src);

        if (dist.length > 0) {
            System.out.println("Shortest distances from source " + src + ":");
            System.out.println(Arrays.toString(dist));
        }
    }
}