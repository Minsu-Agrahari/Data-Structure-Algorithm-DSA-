package NonLineal_DSA.Graph.CycleDetection.UnDirectedGraph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class cycleDetection {

    static class GraphStr{
        int vertex ;
        List<List<Integer>> graph;

        GraphStr(int vertex) {
            this.vertex = vertex;
            this.graph = new ArrayList<>();

            for(int i=0; i<vertex; i++){
                graph.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v){
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        void display() {
            for (int i = 0; i < vertex; i++){
                System.out.println(i + " : " + graph.get(i));
            }
        }

        // cycle detection --- DFS
        boolean cycleDetection_DFS(int src, boolean[] visited, int parent){
            visited[src] = true;

            for(int dis : graph.get(src)){
                if(!visited[dis]){
                    if(cycleDetection_DFS(dis, visited, src)){
                        return true;
                    }
                }else if(dis != parent){
                    return true;
                }
            }

            return false;
        }

        // cycle detection --- bfs
        boolean cycleDetection_BFS(int src, boolean[] visited){

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{src, -1});
            visited[src] = true;

            while (!q.isEmpty()){
                int[] curr = q.poll();
                int node = curr[0];
                int parent = curr[1];

                for(int dis : graph.get(node)){
                    if(!visited[dis]){
                        q.offer(new int[]{dis, node});
                        visited[dis] = true;
                    }else if(dis != parent){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static void main(String[] args) {
        GraphStr g = new GraphStr(5);

        g.addEdge(0,1);
        g.addEdge(2,1);
        g.addEdge(2,3);
        g.addEdge(3,1);
        g.addEdge(4,2);

        g.display();

        System.out.println("DFS Cycle Detection :- " +g.cycleDetection_DFS(0, new boolean[5], -1));
        System.out.println("BFS Cycle Detection :- " + g.cycleDetection_BFS(0, new boolean[5]));
    }
}
