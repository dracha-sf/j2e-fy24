package graphsassignmentquestions;
import java.util.*;
public class Problem5
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];

        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = countSmallerOrEqual(matrix, mid);

            if (count < k) {
                start = mid + 1;
            } 
            else
            {
                end = mid;
            }
        }

        return start;
    }

    private int countSmallerOrEqual(int[][] matrix, int target) 
    {
        int count = 0;
        int n = matrix.length;
        int row = 0;
        int col = n - 1;

        while (row < n && col >= 0) 
        {
            if (matrix[row][col] <= target) 
            {
                count += col + 1;
                row++;
            } 
            else 
            {
                col--;
            }
        }

        return count;
    }

    public static void main(String[] args) 
    {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;

        Problem5 solution = new Problem5();
        int kthSmallest = solution.kthSmallest(matrix, k);
        System.out.println(kthSmallest); // Output: 13
    }
}
