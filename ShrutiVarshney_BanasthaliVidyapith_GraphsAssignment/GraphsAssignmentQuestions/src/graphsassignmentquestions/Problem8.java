package graphsassignmentquestions;
import java.util.*;
class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) 
    {
        this.val = val;
    }
}
public class Problem8 
{
    private int maxPathSum;

    public int maxPathSum(TreeNode root) 
    {
        maxPathSum = Integer.MIN_VALUE;
        calculateMaxPathSum(root);
        return maxPathSum;
    }

    private int calculateMaxPathSum(TreeNode node) 
    {
        if (node == null) 
        {
            return 0;
        }

        // Recursively calculate the maximum path sum for the left and right subtrees
        int leftSum = Math.max(0, calculateMaxPathSum(node.left));
        int rightSum = Math.max(0, calculateMaxPathSum(node.right));

        // Update the maximum path sum if the current path sum is greater
        maxPathSum = Math.max(maxPathSum, node.val + leftSum + rightSum);

        // Return the maximum path sum that can be extended from the current node
        return node.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) 
    {
        // Create the example tree
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Problem8 solution = new Problem8();
        int maxPathSum = solution.maxPathSum(root);
        System.out.println(maxPathSum); // Output: 42
    }
}
