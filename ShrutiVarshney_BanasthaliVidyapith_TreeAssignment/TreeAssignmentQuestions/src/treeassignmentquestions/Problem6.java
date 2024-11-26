package treeassignmentquestions;
public class Problem6 
{
    public static boolean isValidBST(TreeNode root) 
    {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode node, Integer min, Integer max) 
    {
        if (node == null) 
        {
            return true;
        }

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) 
        {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) 
    {
        // Create example tree 1: [2, 1, 3]
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        // Check if the tree is a valid BST
        boolean result1 = isValidBST(root1);

        // Print the result
        System.out.println("Is the tree a valid BST? " + result1);

        // Create example tree 2: [5, 1, 4, null, null, 3, 6]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        // Check if the tree is a valid BST
        boolean result2 = isValidBST(root2);

        // Print the result
        System.out.println("Is the tree a valid BST? " + result2);
    }
}
