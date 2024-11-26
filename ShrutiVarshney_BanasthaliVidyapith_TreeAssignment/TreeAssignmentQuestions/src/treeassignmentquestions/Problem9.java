package treeassignmentquestions;
public class Problem9 
{
    public static int rangeSumBST(TreeNode root, int low, int high) 
    {
        if (root == null) 
        {
            return 0;
        }

        if (root.val < low)
        {
            return rangeSumBST(root.right, low, high);
        } 
        else if (root.val > high)
        {
            return rangeSumBST(root.left, low, high);
        } 
        else 
        {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }

    public static void main(String[] args) 
    {
        // Create example tree 1: [10, 5, 15, 3, 7, null, 18]
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(18);

        int low1 = 7;
        int high1 = 15;
        int result1 = rangeSumBST(root1, low1, high1);
        System.out.println("Range sum of values between " + low1 + " and " + high1 + ": " + result1);

        // Create example tree 2: [10, 5, 15, 3, 7, 13, 18, 1, null, 6]
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(18);
        root2.left.left.left = new TreeNode(1);
        root2.left.right.left = new TreeNode(6);

        int low2 = 6;
        int high2 = 10;
        int result2 = rangeSumBST(root2, low2, high2);
        System.out.println("Range sum of values between " + low2 + " and " + high2 + ": " + result2);
    }
}
