/*
Find the number of unique paths in a n X m grid, starting from [0,0] to [n-1,m-1], where movement is only allowed
either 1 cell down or 1 cell right at a time.
*/
package salesforce.recursion;

public class problem2 {
     public static int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n];

        // Fill the first column with 1 as there is only one way to reach any cell in the first column (by moving down)
        for (int i = 0; i < m; i++) {
            mat[i][0] = 1;
        }

        // Fill the first row with 1 as there is only one way to reach any cell in the first row (by moving right)
        for (int j = 0; j < n; j++) {
            mat[0][j] = 1;
        }

        // Fill the remaining cells based on the number of ways from the above and left cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
            }
        }

        // The value at mat[m-1][n-1] represents the number of unique paths from [0,0] to [m-1,n-1]
        return mat[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int paths = uniquePaths(m, n);
        System.out.println("Number of unique paths: " + paths);
    }
}
