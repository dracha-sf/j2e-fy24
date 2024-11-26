package graphsassignmentquestions;
import java.util.*;
public class Problem11 
{
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int rows;
    private int cols;

    public int longestIncreasingPath(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
        {
            return 0;
        }

        rows = matrix.length;
        cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int maxLength = 0;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                int pathLength = dfs(matrix, i, j, memo);
                maxLength = Math.max(maxLength, pathLength);
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) 
    {
        if (memo[i][j] != 0)
        {
            return memo[i][j];
        }

        int maxLength = 1;

        for (int[] dir : directions)
        {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[i][j]) 
            {
                int pathLength = 1 + dfs(matrix, newRow, newCol, memo);
                maxLength = Math.max(maxLength, pathLength);
            }
        }

        memo[i][j] = maxLength;
        return maxLength;
    }

    public static void main(String[] args) 
    {
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };

        Problem11 solution = new Problem11();
        int length = solution.longestIncreasingPath(matrix);
        System.out.println(length); // Output: 4
    }
}
