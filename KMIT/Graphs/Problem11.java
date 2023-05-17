/*
Problem 11:

Implement a function to find the length of the longest increasing path in a matrix of integers, where a path is
defined as a sequence of cells that are adjacent horizontally or vertically and whose values are in strictly increasing
order.


Example:
Input:
matrix = [[9,9,4],
[6,6,8],
[2,1,1]]
Output:
4

*/

import java.util.*;
class Problem11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        Problem11 p = new Problem11();
        int longestPath = p.longestIncreasingPath(matrix);
        System.out.println(longestPath);
        sc.close();
    }
    public int longestIncreasingPath(int[][] matrix) {
        Integer[][] cache = new Integer[matrix.length][matrix[0].length];
        int longest = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                longest = Math.max(longest, dfs(i, j, -1, matrix, cache));
            }
        }
        return longest;
    }

    public int dfs(int row, int col, int parent, int[][] matrix, Integer[][] cache){
        if(row < 0 || row == matrix.length || col < 0 || col == matrix[0].length ||
          matrix[row][col] <= parent){
            return 0;
        }
        if(cache[row][col] != null){
            return cache[row][col];
        }
        int up = 1 + dfs(row + 1, col, matrix[row][col], matrix, cache);
        int down = 1 + dfs(row - 1, col, matrix[row][col], matrix, cache);
        int left = 1 + dfs(row, col - 1, matrix[row][col], matrix, cache);
        int right = 1 + dfs(row, col + 1, matrix[row][col], matrix, cache);    
        int longestPath = Math.max(Math.max(up, down), Math.max(left, right));
        cache[row][col] = longestPath;
        return longestPath;
    }
}
