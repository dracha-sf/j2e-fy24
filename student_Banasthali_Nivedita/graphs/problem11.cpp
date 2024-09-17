/*
 Implement a function to find the length of the longest increasing path in a matrix of integers, where a path is
defined as a sequence of cells that are adjacent horizontally or vertically and whose values are in strictly increasing
order.
*/
#include<bits/stdc++.h>

using namespace std;

int longestIncreasingPath(vector<vector<int>>& matrix) {
    if (matrix.empty()) {
        return 0;
    }

    int rows = matrix.size();
    int cols = matrix[0].size();
    vector<vector<int>> dp(rows, vector<int>(cols, 0));
    int longestPath = 0;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            longestPath = max(longestPath, dfs(matrix, dp, i, j));
        }
    }

    return longestPath;
}

int dfs(vector<vector<int>>& matrix, vector<vector<int>>& dp, int i, int j) {
    if (dp[i][j] != 0) {
        return dp[i][j];
    }

    int rows = matrix.size();
    int cols = matrix[0].size();
    int longestPath = 1;
    int dirs[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (auto& dir : dirs) {
        int x = i + dir[0];
        int y = j + dir[1];

        if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] > matrix[i][j]) {
            longestPath = max(longestPath, 1 + dfs(matrix, dp, x, y));
        }
    }

    dp[i][j] = longestPath;
    return longestPath;
}

int main() {
    vector<vector<int>> matrix = {
        {9, 9, 4},
        {6, 6, 8},
        {2, 1, 1}
    };

    int longestPath = longestIncreasingPath(matrix);
    cout << "Length of the longest increasing path: " << longestPath << endl;

    return 0;
}

