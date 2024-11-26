package treeassignmentquestions;
public class Problem4 
{
    public static boolean isBalanced(TreeNode root)
    {
        return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode root)
    {
        if (root == null) 
        {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1)
        {
            return -1; // Left subtree is unbalanced, propagate the result
        }

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) 
        {
            return -1; // Right subtree is unbalanced, propagate the result
        }

        if (Math.abs(leftHeight - rightHeight) > 1)
        {
            return -1; // Tree is unbalanced, return -1
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) 
    {
        // Create example tree 1: [3, 9, 20, null, null, 15, 7]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        // Check if the tree is balanced
        boolean result1 = isBalanced(root1);

        // Print the result
        System.out.println("Is the tree balanced? " + result1);

        // Create example tree 2: [1, 2, 2, 3, 3, null, null, 4, 4]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);

        // Check if the tree is balanced
        boolean result2 = isBalanced(root2);

        // Print the result
        System.out.println("Is the tree balanced? " + result2);

        // Create example tree 3: []
        TreeNode root3 = null;

        // Check if the tree is balanced
        boolean result3 = isBalanced(root3);

        // Print the result
        System.out.println("Is the tree balanced? " + result3);
    }
}
