package treeassignmentquestions;
import java.util.*;
public class Problem5 
{
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) 
    {
        if (root1 == null) 
        {
            return root2;
        }
        if (root2 == null) 
        {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);

        return merged;
    }

    public static void main(String[] args) 
    {
        // Create example tree 1: [1, 3, 2, 5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        // Create example tree 2: [2, 1, 3, null, 4, null, 7]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        // Merge the trees
        TreeNode merged = mergeTrees(root1, root2);

        // Print the merged tree using level order traversal
        System.out.print("Merged tree: ");
        printTreeLevelOrder(merged);
        System.out.println();
    }

    // Helper method to print the tree using level order traversal
    private static void printTreeLevelOrder(TreeNode root)
    {
        if (root == null) 
        {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) 
        {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null)
            {
                queue.add(node.left);
            }

            if (node.right != null)
            {
                queue.add(node.right);
            }
        }
    }
}
