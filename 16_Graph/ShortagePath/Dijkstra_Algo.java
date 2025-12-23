package NonLineal_DSA.Graph.ShortagePath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra_Algo {

    // Pair class to store (vertex, distance)
    static class Pair{
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Dijkstra algorithm
    public static int[] dijkstra(int vertex, List<List<Pair>> graph, int src) {

        // Distance Array
        int[] dist = new int[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b) -> a.distance - b.distance
        );

        pq.add(new Pair(src, 0));

        // iterating in PriorityQueue
        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            // top element :- src and weight
            int u = curr.node;
            int currDist = curr.distance;

            // skip outdated entries: This entry is stale (outdated) because a shorter path to u was already discovered later and stored in dist[u].
            if(currDist > dist[u]) continue;

            for(Pair neighbor : graph.get(u)){
                int v = neighbor.node;
                int weight = neighbor.distance;

                // EDGE RELAXATION
                if(dist[v] > dist[u] + weight){
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    // Driver code
    public static void main(String[] args) {

        int vertex = 6;
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }

        // Adding edges (undirected graph)
        graph.get(0).add(new Pair(1, 2));
        graph.get(0).add(new Pair(2, 4));

        graph.get(1).add(new Pair(2, 1));
        graph.get(1).add(new Pair(3, 7));

        graph.get(2).add(new Pair(4, 3));

        graph.get(3).add(new Pair(5, 1));

        graph.get(4).add(new Pair(3, 2));
        graph.get(4).add(new Pair(5, 5));

        int src = 0;
        int[] result = dijkstra(vertex, graph, src);

        System.out.println("Shortest distance from source: "+ src +":");
        System.out.println(Arrays.toString(result));
    }
}
