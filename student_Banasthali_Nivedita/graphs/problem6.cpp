/*
6. Implement a function to find the number of ways to reach the bottom-right corner of a m x n grid from the top-left
corner, where each cell contains a non-negative integer representing the cost to traverse it. You can only move
down or right at each step.

*/

#include <iostream>
#include <vector>

using namespace std;

int uniquePaths(vector<vector<int>>& grid) {
    int m = grid.size();
    int n = grid[0].size();

    vector<vector<int>> dp(m, vector<int>(n, 0));

    dp[0][0] = 1;

    for (int j = 1; j < n; j++) {
        dp[0][j] = dp[0][j - 1] + grid[0][j];
    }

    
    for (int i = 1; i < m; i++) {
        dp[i][0] = dp[i - 1][0] + grid[i][0];
    }

   
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
    }

    return dp[m - 1][n - 1];
}

int main() {
    vector<vector<int>> grid = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };

    int numWays = uniquePaths(grid);
    cout << "Number of ways: " << numWays << endl;

    return 0;
}

