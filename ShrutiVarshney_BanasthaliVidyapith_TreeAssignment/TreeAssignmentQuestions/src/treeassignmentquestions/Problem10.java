package treeassignmentquestions;
import java.util.*;
public class Problem10 
{
    public static TreeNode searchBST(TreeNode root, int val) 
    {
        if (root == null || root.val == val) 
        {
            return root;
        }

        if (val < root.val) 
        {
            return searchBST(root.left, val);
        } 
        else 
        {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) 
    {
        // Create example BST: [4, 2, 7, 1, 3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 2;
        TreeNode result = searchBST(root, val);

        System.out.println("Level order traversal of the subtree rooted with node value " + val + ":");
        printLevelOrder(result);
    }

    private static void printLevelOrder(TreeNode root) 
    {
        if (root == null) 
        {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) 
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
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
}
