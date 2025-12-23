package NonLineal_DSA.Graph.Traversal.BFS;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class unDir_unWt_BFSTraversal {
    static class Graph{
        int vertex;
        List<List<Integer>> grpah;

        public Graph(int vertex) {
            this.vertex = vertex;
            grpah = new ArrayList<>();

            // each list --> list
            for(int i=0; i<vertex; i++) {
                grpah.add(new ArrayList<>());
            }
        }

        // add vertex
        void addVertex(int u, int v){
            grpah.get(u).add(v);
            grpah.get(v).add(u);
        }

        // display
        void display() {
            for (int i = 0; i < vertex; i++) {
                System.out.println(i + " : " + grpah.get(i));
            }
        }

        void BFSTraversal(){
            System.out.println("---- BFS NonLineal_DSA.Graph.Traversal Start ----");
            Queue<Integer> q = new LinkedList<>();

            boolean[] visited = new boolean[vertex];
            Arrays.fill(visited, false);

            visited[0] = true;

            // Source insertion in the Queue
            q.offer(0);

            System.out.print("Graph Element :- ");
            while(!q.isEmpty()){
                int first = q.poll();

                System.out.print(first + " ");

                for(int i=0; i<grpah.get(first).size(); i++){
                    int node = grpah.get(first).get(i);
                    if(!visited[node]){
                        visited[node] = true;
                        q.offer(node);
                    }
                }
            }
        }
    }
    static void main(String[] args) {

        int vertex = 5;
        Graph g = new Graph(vertex);

        g.addVertex(0, 1);
        g.addVertex(2, 1);
        g.addVertex(2, 4);
        g.addVertex(1, 3);

        g.display();
        g.BFSTraversal();
    }
}
