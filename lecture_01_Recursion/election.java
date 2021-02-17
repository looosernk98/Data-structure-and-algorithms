import java.io.*;
import java.util.*;

public class election{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn= new Scanner(System.in);
    
    int n= scn.nextInt();
    String str=scn.next();
    
    String ans="";
    int ca=0;
    int cb=0;
    for(int i=0; i<n; i++){
        char ch= str.charAt(i);
        if(ch=='-'){
            if(i!=0 && i!=n-1){
                char left= str.charAt(i-1);
               char right= str.charAt(i+1);
               if(left=='B' && right=='-'){
                   ans+='B';
                   cb++;
               }else if(left=='-' && right=='A'){
                   ans+='A';
                   ca++;
               }else{
                   ans+=ch;
               }
            }else if(i==0){
                char right= str.charAt(i+1);
                if(right=='A'){
                    ans+=right;
                    ca++;
                }else{
                    ans+=ch;
                }
            }else{
                 char left= str.charAt(i-1);
                if(left=='B'){
                    ans+=left;
                    cb++;
                }else{
                    ans+=ch;
                }
            }
           
        }else{
            ans+=ch;
            if(ch=='A') ca++;
            if(ch=='B') cb++;
        }
    }
    
    if(ca>cb){
        System.out.println('A');
    }else if(cb>ca){
        System.out.println('B');
    }else{
        System.out.println("Coalition government"); 
    }
  
}

}


