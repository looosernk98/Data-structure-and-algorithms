package standard_algorithms.prims;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class prims_mst_algo {
    static class Edge{
        int src;
        int nbr;
        int wt;

        Edge(int s, int n, int w){
          this.src = s;
          this.nbr = n;
          this.wt = w;
        }
    }
    static class Pair implements Comparable<Pair>{
      int vtx; // parent
      int par;
      int wt;

      Pair(int vtx, int par, int wt){
          this.vtx = vtx;
          this.par = par;
          this.wt = wt;
      }

      @Override
      public int compareTo(Pair o){
        return this.wt - o.wt;
      }

  }

    // GOAL of prims or MST(Minimum spanning tree) -> To find the minimum cost to cover all nodes
    // MST -> acyclic, all vertcies are connected

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       // FileReader fileReader = new FileReader("/input.txt");
       // BufferedReader buffReader = new BufferedReader(fileReader); 
 
       // while (buffReader.ready()) { 
       //     System.out.println( 
       //         buffReader.readLine()); 
       // } 
       // buffReader.close();

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for(int i =0; i<graph.length; i++){
           graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());

        for(int i = 0; i<edges; i++){
           String[] parts = br.readLine().split(" ");
           int u = Integer.parseInt(parts[0]);
           int v = Integer.parseInt(parts[1]);
           int w = Integer.parseInt(parts[2]);

           graph[u].add(new Edge(u, v, w));
           graph[v].add(new Edge(v, u, w));
        }

        int src = Integer.parseInt(br.readLine());

        br.close();

        boolean[] visited = new boolean[vtces];
        ArrayList<String> mstEdges = new ArrayList<>();
        int overallMinimisedWeight = PQ_BFS(graph, src, visited, mstEdges);

        System.out.println("Minimum weight of MST: "+ overallMinimisedWeight);
        for(String edge: mstEdges){
          System.out.println(edge);
        }
   }

  public static int PQ_BFS(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<String> mstEdges ){
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    int minimumCost = 0;
    pq.add(new Pair(src, -1, 0));

    while(pq.size()!=0){
       Pair rem = pq.remove();

       if(visited[rem.vtx]){
        continue;
       }
       if(rem.par != -1){
         mstEdges.add(rem.vtx + "->" + rem.par + " @"+ rem.wt);
         minimumCost += rem.wt;
       }
       visited[rem.vtx] = true;

       for(Edge e: graph[rem.vtx]){
          if(!visited[e.nbr]){
             pq.add(new Pair(e.nbr, rem.vtx, e.wt));
          }
       }
    }
    return minimumCost;
  }
}
