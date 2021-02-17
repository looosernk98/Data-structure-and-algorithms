import java.util.Stack;
import java.util.ArrayList;
public class questions{

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // leetcode 112
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if(root==null) return false;
       if(root.left==null && root.right==null && targetSum-root.val==0) return false;

       return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }

 // leetcode 113
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
      ArrayList<ArrayList<Integer>> res= new ArrayList<>();
      pathSum(root, targetSum, res, new ArrayList<>());
    
  }
  public void pathSum(TreeNode node, int tar, List<List<Integer>> res, List<Integer> ans){
    if(node==null) return ;
    if(node.left==null && node.right==null && tar-node.val==0){
        List<Integer> list= new ArrayList<>(ans);
        list.add(node.val);
        res.add(list);
        return;
    }
     ans.add(node.val);
     pathSum(node.left, tar-node.val, res, ans);
     pathSum(node.right, tar-node.val, res, ans);
     ans.remove(ans.size()-1);                        // very import step
}
    public static void main(String[] args){
        hasPathSum()
    }
}