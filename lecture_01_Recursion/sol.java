import java.util.*;

public class Main {

    public static void main(String[] args) {

        // write your code here.
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        List<List<Integer>> res= new ArrayList<>();
        boolean vis[]= new boolean[arr.length];
        Arrays.sort(arr);
        permutations(arr,res,vis,new ArrayList<>(),n);
        

    }
    public void  permutations(int[] arr, List<List<Integer>> res,boolean[] vis,List<Integer> smallAns,int n){
        
        if(smallAns.size()==n){
            List<Integer> ans= new ArrayList<>(smallAns);
            res.add(ans);
            return ;
        }
        int prev= (int)-1e8;
       for(int i=0; i<n; i++){
           if(!vis[i] && prev!=arr[i]){
               vis[i]=true;
               smallAns.add(arr[i]);
               permutations(arr,res,vis,smallAns,n); 
               vis[i]=false;
               smallAns.remove(smallAns.size()-1);
                prev=arr[i];
           }
          
       }
    }

}

