import java.util.*;
public class factorOf3{
    public static void main(String[] args){

        Scanner scn= new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]=scn.nextInt();
        }
        List<List<Integer>> sol =new  ArrayList<>();
        boolean visited[]= new boolean[n];
        Arrays.sort(arr);
        boolean test=permutations(arr,sol,visited,new ArrayList<>(),n);
        if(test==true){
            System.out.println("YES");
        }else{
             System.out.println("NO");
        }
        
        
    }
    public static boolean permutations(int[] arr,List<List<Integer>> sol,boolean[] visited,List<Integer> ans, int n ){
        if(ans.size()==n){
            List<Integer> res= new ArrayList<>(ans);
            sol.add(res);
            return checkDiv(res);
    
        }

        int prev= (int)-1e8;
        for(int i=0; i<n; i++){
            if(!visited[i] && prev!=arr[i]){
                visited[i]=true;
                ans.add(arr[i]);
                boolean test=permutations(arr,sol,visited,ans,n);
                if(test==true){
                    return true;
                }
                visited[i]= false;
                ans.remove(ans.size()-1);
               prev=arr[i];
            }
        }
        return false;
        
    }
    public static boolean checkDiv(List<Integer> list ){
       
        
            for(int j=0; j<list.size()-1; j++){
                if((list.get(j)+list.get(j+1))%3>=1){
                    return true;
                }
            }
        return false;
    }
}