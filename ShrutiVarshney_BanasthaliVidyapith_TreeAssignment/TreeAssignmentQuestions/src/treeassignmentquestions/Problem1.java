package treeassignmentquestions;
class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) 
    {
        val = x;
    }
}
public class Problem1 
{
    public static boolean isSameTree(TreeNode p, TreeNode q) 
    {
        // Base case: if both trees are empty, they are considered the same
        if (p == null && q == null) 
        {
            return true;
        }

        // If one of the trees is empty but the other isn't, they are not the same
        if (p == null || q == null) 
        {
            return false;
        }

        // If the values of the current nodes are different, they are not the same
        if (p.val != q.val) 
        {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) 
    {
        // Create tree 1: [1, 2, 3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Create tree 2: [1, 2, 3]
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // Check if the trees are the same
        boolean result = isSameTree(p, q);

        // Print the result
        System.out.println("Are the trees the same? " + result);
    }
}
