package treeassignmentquestions;

public class Problem2 
{
    public static boolean isSymmetric(TreeNode root) 
    {
        if (root == null) 
        {
            return true; // An empty tree is symmetric
        }

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode node1, TreeNode node2) 
    {
        if (node1 == null && node2 == null) 
        {
            return true; // Both nodes are null, they are considered mirrors
        }

        if (node1 == null || node2 == null) 
        {
            return false; // One node is null but the other isn't, they are not mirrors
        }

        // Check if the values of the current nodes are the same
        if (node1.val != node2.val) 
        {
            return false;
        }

        // Recursively check if the left subtree of node1 is a mirror of the right subtree of node2
        // and if the right subtree of node1 is a mirror of the left subtree of node2
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    public static void main(String[] args) 
    {
        // Create example tree 1: [1, 2, 2, 3, 4, 4, 3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        // Check if the tree is symmetric
        boolean result1 = isSymmetric(root1);

        // Print the result
        System.out.println("Is the tree symmetric? " + result1);

        // Create example tree 2: [1, 2, 2, null, 3, null, 3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        // Check if the tree is symmetric
        boolean result2 = isSymmetric(root2);

        // Print the result
        System.out.println("Is the tree symmetric? " + result2);
    }
}
