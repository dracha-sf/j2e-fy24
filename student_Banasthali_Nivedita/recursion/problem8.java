/*
Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have
Node.val == 0.
Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 */
package salesforce.recursion;
import java.util.*;
import salesforce.linkedLists.ListNode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}


public class problem8 {
     public static List<TreeNode> generateTree(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>(); // If n is even, it's not possible to form full binary trees
        }

        return generateTreeRecr(n);
    }

    private static List<TreeNode> generateTreeRecr(int n) {
        List<TreeNode> trees = new ArrayList<>();

        // Base case: If n is 1, return a single tree with a single node (0)
        if (n == 1) {
            trees.add(new TreeNode(0));
            return trees;
        }

        // Try different combinations of left and right subtree node counts
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftSubtrees = generateTreeRecr(i);
            List<TreeNode> rightSubtrees = generateTreeRecr(n - i - 1);

            // Create trees by combining left and right subtrees
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }

        return trees;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> result = generateTree(n);

        for (TreeNode root : result) {
            printTree(root);
            System.out.println();
        }
    }

    public ListNode mergeLists(ListNode list1, int a, int b, ListNode list2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void printList(ListNode mergedList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
