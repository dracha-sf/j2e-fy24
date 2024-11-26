package recursionassignmentquestions;
import java.util.*;
public class Problem2 
{
    public static int uniquePaths(int n, int m) 
    {
        // Create a 2D array to store the number of unique paths for each cell
        int[][] dp = new int[n][m];

        // Initialize the first row and first column with 1, as there is only one way to reach each cell in the first row and first column
        for (int i = 0; i < n; i++) 
        {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) 
        {
            dp[0][j] = 1;
        }

        // Compute the number of unique paths for each cell
        for (int i = 1; i < n; i++) 
        {
            for (int j = 1; j < m; j++) 
            {
                // The number of unique paths to reach cell [i][j] is the sum of the number of unique paths to reach the cell above it [i-1][j]
                // and the number of unique paths to reach the cell on its left [i][j-1]
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the number of unique paths to reach the bottom-right corner [m-1][n-1]
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int n = sc.nextInt(); 
        System.out.println("Enter the number of columns:");
        int m = sc.nextInt();
        System.out.println("Number of unique paths for m = " + n + ", n = " + m + ": " + uniquePaths(n, m));
    }
}
