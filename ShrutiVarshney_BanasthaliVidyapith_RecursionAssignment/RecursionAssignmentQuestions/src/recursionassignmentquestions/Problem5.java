package recursionassignmentquestions;
import java.util.*;
class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) 
    {
        this.val = val;
    }
}
public class Problem5 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();

        List<TreeNode> trees = generateFullBinaryTrees(n);
        for (TreeNode root : trees) 
        {
            System.out.println("Tree:");
            printTree(root);
            System.out.println();
        }
    }

    public static List<TreeNode> generateFullBinaryTrees(int n) 
    {
        List<TreeNode> result = new ArrayList<>();

        if (n == 1) 
        {
            TreeNode root = new TreeNode(0);
            result.add(root);
        } 
        else if (n % 2 == 1) 
        {
            for (int i = 1; i < n; i += 2) 
            {
                List<TreeNode> leftSubtrees = generateFullBinaryTrees(i);
                List<TreeNode> rightSubtrees = generateFullBinaryTrees(n - i - 1);

                for (TreeNode left : leftSubtrees) 
                {
                    for (TreeNode right : rightSubtrees) 
                    {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }

        return result;
    }

    public static void printTree(TreeNode root) 
    {
        if (root == null) 
        {
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
