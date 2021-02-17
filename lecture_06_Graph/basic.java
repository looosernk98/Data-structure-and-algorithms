public class basic{
int N=9;
ArrayList<Integer> graph[]= new ArrayList[N];

    public static void add(int u, int v){
       graph[u].add(v);
    }

    public static void topoDFS(int src, boolean vis[], Stack<Integer> st){
        vis[src]=true;

        for(int e: graph[src]){
            if(!vis[e]){
                topoDFS(e,vis);
            }
        }

        st.push(src);
    }
    public static void topological_order(){
        boolean vis[]= new boolean[N];
        Stack<Integer> st= new Stack<>();
        for(int i=0; i<N; i++){
            if(!vis[i]){
                topDFS(i,vis,st);
            }
        }
    } 

    // khans algo
    public static void topological order(){
        int[] indegree= new int[N];
        for(int i=0; i<N; i++) {
            for(int e: graph[i]) indegree[e]++;
        }

        ArrayDeque<Integer> que= new ArrayDeque<>();
        ArrayList<Integer> list= new ArrayList<>();

        for(int i=0; i<N; i++) {
            if(indegree[i]==0) que.add(i);
        }

        while(que.size()!=0){
            int vtx= que.removeFirst();
            list.add(vtx);

            for(int e : graph[vtx]){
                if(--indegree[e]==0){
                    que.add(e);
                }
            }

        }

        if(list.size()!=N) System.out.println("cycle");
        else System.out.println(list);
    }

    public static void main(String[] args){
       add(5,0);
       add(5,2);
       add(2,3);
       add(3,1);
       add(4,0);
       add(4,6);
       add(6,7);
       add(7,8);
       add(8,1);

       
    }


    static int[] par;
    static int[] size;

    public static int findPar(int u){
        if(u=part[u]) return u;
        else par[u]=findPar(par[u]);
    }

    public static void merge(int p1, int p2){
        if(size[p1]<size[p2]){
            par[p1]=p2;
            size[p2]+=size[p1];
        }else{
            par[p2]=p1;
            size[p1]+=size[p2];
        }
    }
    public static void unionFind(int[][] gp){
        for(int i=0; i<N; i++){
            graph[i]= new ArrayList<>()
        }

        Arrays.sort(gp, (a,b)->{
          //return a[2]-b[2];
          return b[2]-a[2];
        });
        
        for(int i=0; i<N; i++){
            par[i]=i
        }



        for(int[] a: gp){
            int u= a[0];
            int v= a[1];
            int w= a[2];

            int p1= findPar(u);
            int p2= findPar(v);

            if(p1!=p2){
                addEdge(u,v,w);
                merge(p1,p2);
               // par[p1]=p2;
            }
        }
    }
} 