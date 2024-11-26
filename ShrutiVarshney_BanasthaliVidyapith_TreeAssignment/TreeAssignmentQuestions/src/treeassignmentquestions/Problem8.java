package treeassignmentquestions;
import java.util.*;
public class Problem8 
{
    public static TreeNode sortedArrayToBST(int[] nums) 
    {
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int start, int end) 
    {
        if (start > end) 
        {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = buildBST(nums, start, mid - 1);
        node.right = buildBST(nums, mid + 1, end);

        return node;
    }

    public static void main(String[] args) 
    {
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        // Perform level order traversal
        System.out.print("Level order traversal of the BST: ");
        levelOrderTraversal(root);
        System.out.println();
    }

    private static void levelOrderTraversal(TreeNode root) 
    {
        if (root == null) 
        {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) 
        {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) 
            {
                queue.offer(node.left);
            }
            if (node.right != null) 
            {
                queue.offer(node.right);
            }
        }
    }
}
