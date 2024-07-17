package standard_algorithms.dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

// GOAL of Dijkstra -> to find the shortest path from a single source to all other nodes in terms of weights
// Dijkstra algo uses BFS technique using PriorityQueue instead of Queue to find shortest path

class DijkstraAlgo{

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
        int vtx; // end point of of considered path from src
        int wsf;
        String psf;

        Pair(int v, int wt, String psf){
            this.vtx = v;
            this.wsf = wt;
            this.psf = psf;
        }

        @Override
        public int compareTo(Pair o){
          return this.wsf - o.wsf;
        }

    }
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
        //  int dest = Integer.parseInt(br.readLine());

         br.close();

         ArrayList<String> paths = new ArrayList<>(); 
         boolean[] visited = new boolean[vtces];

         PQ_BFS(graph, src,visited, paths);
        
         for(String path: paths){
          System.out.println(path);
         }
        //  System.out.println("path from " + src+" to "+ dest+" : " + path[0]);
        //  System.out.println("path weight " + src+" to "+ dest+" : " + path[1]);
        //  System.out.println("==========================================");
         
    }


    public static void PQ_BFS(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<String> paths){
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      
      pq.add(new Pair(src, 0, src+""));

      while(pq.size()!=0){
        Pair rem = pq.remove();
        if(visited[rem.vtx]){
          continue;
        }
        paths.add(rem.psf + " @ "+ rem.wsf);

        visited[rem.vtx] = true;

        
        for(Edge e: graph[rem.vtx]){
            if(!visited[e.nbr]){
                pq.add(new Pair(e.nbr, rem.wsf + e.wt, rem.psf + " -> " + e.nbr));
            }
        }
        // visited[rnode.ep] = false; // not required as we do not backtrack, we are just travel along a shortest path
      }
    }
}


