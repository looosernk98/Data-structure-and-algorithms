public class basic{
    public static void main(String[] args){
        solve();
       
    }
    public static void solve(){
        // int sr=0, sc=0, dr=2,dc=2;
        // System.out.print(mazePaths(sr,sc,dr,dc,""));
        //floodFill();
        String str="abcd";
        Allpermutations(str,"");
    }
    public static int mazePaths(int sr, int sc, int dr, int dc,String ans){
      if(sr==dr && sc==dc){
          System.out.println(ans);
          return 1;
      }
       int count=0; 
      if(sc+1<=dc) count +=mazePaths(sr,sc+1,dr,dc,ans+"H");
      if(sr+1<=dr) count +=mazePaths(sr+1,sc,dr,dc,ans+"V");
      if(sc+1<=dc && sr+1<=dr) count +=mazePaths(sr+1,sc+1,dr,dc,ans+"D");

      return count;
    }

    public static int mazePathMulti(int sr,int sc,int er,int ec,String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);
            return 1;
        }

        int count=0;
        
        for(int jump=1; sc + jump <= ec;jump++)  count+=mazePathMulti(sr,sc+jump,er,ec,ans+"H"+jump);
        for(int jump=1;sr + jump <= er;jump++) count+=mazePathMulti(sr+jump,sc,er,ec,ans+"V"+jump);
        for(int jump=1;sc + jump <= ec && sr + jump <= er; jump++)  count+=mazePathMulti(sr+jump,sc+jump,er,ec,ans+"D"+jump);
        
        return count;

    }

    public static int floodFill_(int sr,int sc,int er, int ec, boolean[][] vis, int[][] dir, String[] dirS,String ans){
       if(sr==er && sc==ec){
           System.out.println(ans);
           return 1;
       }
        
       vis[sr][sc]=true;
       int count=0;
       for(int d=0; d<4; d++){
           int r= sr + dir[d][0];
           int c= sc + dir[d][1];

           if(r>=0 && c>=0 && r<=er && c<=ec && vis[r][c]==false){
               count+=floodFill_(r,c,er,ec,vis,dir,dirS,ans+dirS[d]);
           }
          
       }
       vis[sr][sc]=false;

       return count;

    }
    public static void floodFill(){
        int sr=0, sc=0, er=3, ec=3;
        int[][] dirFour= {{1,0},{-1,0},{0,1},{0,-1}};
        String[] dirFourS= {"D","U","R","L"};
        boolean vis[][]= new boolean[er+1][ec+1];

        System.out.println(floodFill_(sr,sc,er,ec,vis,dirFour,dirFourS,""));
    }
    
    public static int floodfill_multiJump(int sr, int sc, int er, int ec, boolean vis[][], int dir[][], String[] dirS, String ans){
        if(sr==er && sc==ec){
            System.out.println(ans);
            return 1;
        }

        vis[sr][sc]=true;
        int count=0;
        for(int jump=1; jump<=Math.max(er,ec); jump++){
            for(int d=0; d<4; d++){
                int r= sr +jump* dir[d][0];
                int c= sc +jump* dir[d][1];

                if(r>=0 && c>=0 && r<=er && c<=ec && vis[r][c]==false){
                    count += floodfill_multiJump(r, c, er, ec, vis, dir, dirS,ans+dirS[d]+jump);
                }
            }
        }
        vis[sr][sc]= false;
        return count;
    }
    public static int Allpermutations(String ques, String ans){
       
        if(ques.length()==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=0; i<ques.length(); i++){
            char ch= ques.charAt(i);
            String roq= ques.substring(0,i)+ques.substring(i+1);
            count+=Allpermutations(roq, ans+ch);
        }
        return count;
    }

    public static int unique_permutations(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return 1;
        }
        boolean[] vis= new boolean[26];
        int count=0;
        for(int i=0; i<str.length(); i++){
            char ch= str.charAt(i);
            String roq= str.substring(0,i)+str.substring(i+1);
            if(!vis[ch-'A']){
                count+=permutations(roq, ans+ch);
                vis[ch-'A']=true;
            }   
           
        }
        return count;
    }

    public List<String> letterCombinations_set2(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        String[] codes={".,/?", "@#$%", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz","*+-","&^!~"};
        
        List<String> ans=new ArrayList<>();
        letterCombinations(digits,0,codes,ans,"");
        return ans;
    }
    public static int letterCombinations(String digits, idx, String[] codes,List<String> ans, String res ){
        if(idx==digits.length()){
            ans.add(res);
            return 1;
        }
          
        int cidx=(digits.charAt(idx)-'0');
        String code=codes[cidx];
        int count=0;
        for(int i=0; i<code.length(); i++){
           count+= letterCombinations(digits,idx+1,codes,ans,res+code.charAt(i));
        }

        if(idx<digits.length()){   // is it necessary ?????????????????
            cidx= idx*10 + (digits.charAt(idx+1)-'0');
            if(cidx>=10 && cidx<=11){
                code=codes[cidx];
                for(int i=0; i<code.length(); i++){
                    count+= letterCombinations(digits,idx+2,codes,ans,res+code.charAt(i));
                 }
            }
        }
        return count;
    }

    //Leetcode 91
 public int numDecodings(String s,int idx,String ans){
    if(idx==s.length()){
        System.out.println(ans);
        return 1;
    }
     char ch=s.charAt(idx);
    int cidx=ch-'0';
    if(cidx==0) return 0;

    int count=0;
    count+=numDecodings(s,idx+1,ans+(char)(cidx+'a'-1));

    if(idx<s.length()-1){
        cidx= cidx*10 + (s.charAt(idx+1)-'0');
        if(cidx>=10 && cidx<=26){
         count+=numDecodings(s,idx+1,ans+(char)(cidx+'a'-1));
        }
    }
     
    return count;
 }
 
}