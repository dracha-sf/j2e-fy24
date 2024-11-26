package graphsassignmentquestions;
import java.util.*;
public class Problem4 
{
    public int numIslands(int[][] grid) 
    {
        if (grid == null || grid.length == 0 || grid[0].length == 0) 
        {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++) 
            {
                if (grid[i][j] == 1) 
                {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(int[][] grid, int row, int col) 
    {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) 
        {
            return;
        }

        grid[row][col] = -1; // Mark the current cell as visited

        // Perform DFS on the neighboring cells
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }

    public static void main(String[] args) 
    {
        int[][] grid = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        Problem4 solution = new Problem4();
        int numIslands = solution.numIslands(grid);
        System.out.println(numIslands); // Output: 1
    }
}
