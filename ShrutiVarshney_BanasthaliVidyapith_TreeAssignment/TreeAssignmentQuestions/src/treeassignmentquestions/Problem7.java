package treeassignmentquestions;
public class Problem7 
{
    private static int count;
    private static int result;

    public static int kthSmallest(TreeNode root, int k) 
    {
        count = 0;
        result = 0;
        inorderTraversal(root, k);
        return result;
    }

    private static void inorderTraversal(TreeNode node, int k) 
    {
        if (node == null) 
        {
            return;
        }

        inorderTraversal(node.left, k);

        count++;
        if (count == k) 
        {
            result = node.val;
            return;
        }

        inorderTraversal(node.right, k);
    }

    public static void main(String[] args)
    {
        // Create example tree 1: [3, 1, 4, null, 2]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);

        // Find the kth smallest element
        int k1 = 1;
        int result1 = kthSmallest(root1, k1);

        // Print the result
        System.out.println("The " + k1 + "th smallest element is: " + result1);

        // Create example tree 2: [5, 3, 6, 2, 4, null, null, 1]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);

        // Find the kth smallest element
        int k2 = 3;
        int result2 = kthSmallest(root2, k2);

        // Print the result
        System.out.println("The " + k2 + "th smallest element is: " + result2);
    }
}
