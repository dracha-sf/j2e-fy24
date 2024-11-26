package treeassignmentquestions;
import java.util.*;
public class Problem3 
{
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right subtrees recursively
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        // Create example tree 1: [4, 2, 7, 1, 3, 6, 9]
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        // Invert the tree
        TreeNode invertedRoot1 = invertTree(root1);

        // Print the inverted tree using level order traversal
        System.out.print("Inverted tree 1: ");
        printTreeLevelOrder(invertedRoot1);
        System.out.println();

        // Create example tree 2: [2, 1, 3]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        // Invert the tree
        TreeNode invertedRoot2 = invertTree(root2);

        // Print the inverted tree using level order traversal
        System.out.print("Inverted tree 2: ");
        printTreeLevelOrder(invertedRoot2);
        System.out.println();
    }

    // Helper method to print the tree using level order traversal
    private static void printTreeLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
