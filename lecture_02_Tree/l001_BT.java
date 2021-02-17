import java.util.LinkedList;
import java.util.ArrayList;
 public class l001_BT{
    public static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
        }

    }
  static int idx=0;
    public static Node constructTree(int[] arr){
        if(idx==arr.length || arr[idx]==-1){
            idx++;
            return null;
        }
      Node root= new Node(arr[idx++]);
      
      root.left=constructTree(arr);
      root.right=constructTree(arr);

      return root;
      
    }
    public static void main(String[] args){
       solve();
    }

    public static void display(Node node){
        if(node==null) return ;
        StringBuilder str= new StringBuilder();
       
        str.append(node.left!=null ? node.left.data : " . ");
        str.append(" <- "+node.data+" -> ");
        str.append(node.right!=null ? node.right.data : " . ");
        
       System.out.println(str.toString());
        display(node.left);
        display(node.right);
    }

    public static int size(Node node){
      return node!=null ? size(node.left)+size(node.right)+1 :0;
    }
    public static int height(Node node){
        return node==null ? -1 : Math.max(height(node.left), height(node.right))+1;
    }
    public static void preOrder(Node node){
        if(node==null) return ;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node){
        if(node==null) return ;
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    public static void postOrder(Node node){
        if(node==null) return ;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }

    // set 1 ==============================================================

    // diamter 1 , O(n^2)
    public static int diameter1(Node node){
        if(node==null) return 0;

        int d1= diameter1(node.left);
        int d2= diameter1(node.right);

        int h1=height(node.left);
        int h2=height(node.right);

        return Math.max(Math.max(d1,d2), h1+h2+2);

    }

    // diameter 2 , O(n)

    public static int[] diameter2(Node node){
        if(node==null) return new int[]{0,-1};

        int[] lr= diameter2(node.left);
        int[] Rr= diameter2(node.right);

        int dia= Math.max(Math.max(lr[0],Rr[0]),lr[1]+Rr[1]+2);
        int height= Math.max(lr[1],Rr[1])+1;

        return new int[]{dia,height};
    }
    // diameter 3, O(n)
//   static int dia;
  public static class pair{
     int dia=0;
     int height=0;
     pair(){

     }
     pair(int dia, int height){
         this.dia=dia;
         this.height=height;
     }
  }
    public static pair diameter3(Node node){
        if(node==null) return new pair(0,-1);

        pair lp= diameter3(node.left);
        pair rp= diameter3(node.right);
        
        pair res= new pair();
        res.dia= Math.max(Math.max(lp.dia,rp.dia), lp.height+rp.height+2);
        res.height= Math.max(lp.height,rp.height)+1;
       return res;
    }

    // https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/

    public int LeafToLeafAns = -(int)1e8;
    public int leafToLeafSum_(Node node){
        if(node == null) return -(int)1e8;
        if(node.left == null && node.right == null) return node.data;

        int lMax = leafToLeafSum_(node.left); 
        int rMax = leafToLeafSum_(node.right);
        
        if(node.left != null && node.right != null){
            LeafToLeafAns = Math.max(LeafToLeafAns, lMax + node.data +rMax);
        }

        return Math.max(lMax,rMax) + node.data;
    }

    int maxPathSum(Node root)
    { 
        leafToLeafSum_(root);
        return LeafToLeafAns;
    } 
      

    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;

        int l= maxPathSum(root.left);
        int r= maxPathSum(root.right);

        NTNres= Math.max(NTNres, l+r+root.val);
        return NTNres;
    }


    public static void solve(){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root = constructTree(arr);
        // display(root);
        // System.out.println(height(root));
        // System.out.println(size(root));
        // preOrder(root);
        // System.out.println();
        // inOrder(root);

        // System.out.println();
        // postOrder(root);
        // int[] res=diameter2(root);
        // System.out.println(res[0]);
        System.out.println(diameter3(root).dia);
       
    }

    
}