package Trees;
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
}

public class t2 {
    public boolean isSymmetric(TreeNode root) {
        return (root==null || helper(root.left,root.right) );
        
    }
    public boolean helper(TreeNode left,TreeNode right){

    
        if(left==null || right==null){
            return (left==right);
        }
        if(left.val!=right.val){
            return false;
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
        
    }
    
}
