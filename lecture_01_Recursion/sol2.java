import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn= new Scanner(System.in);
    int n= scn.nextInt();
    String str=scn.next();
    
    String str="";
    for(int i=0; i<n; i++){
        char ch= str.charAt(i);
        if(ch=='-'){
            if(i!=0 && i!=n-1){
                char left= str.charAt(i-1);
               char right= str.charAt(i+1);
               if(left=='B' && right=='-'){
                   str+='B';
               }else if(left=='-' && right=='A'){
                   str+='A';
               }else{
                   str+=ch;
               }
            }else if(i==0){
                char right= str.charAt(i+1);
                if(right=='A'){
                    str+=right;
                }else{
                    str+=ch;
                }
            }else{
                 char left= str.charAt(i-1);
                if(left=='B'){
                    str+=left;
                }else{
                    str+=ch;
                }
            }
           
        }else{
            str+=ch;
        }
    }
    
    System.out.println(str);
    
 }



}