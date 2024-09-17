/*
Given a matrix of 0's and 1's, implement a function to find the number of islands in the matrix, where an island is a
group of connected 1's.
*/

#include <iostream>
#include <vector>

using namespace std;

void dfs(vector<vector<int>>& matrix, int i, int j) {
    int rows = matrix.size();
    int cols = matrix[0].size();

    if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] != 1) {
        return;
    }

    matrix[i][j] = -1;

    dfs(matrix, i - 1, j); // Up
    dfs(matrix, i + 1, j); // Down
    dfs(matrix, i, j - 1); // Left
    dfs(matrix, i, j + 1); // Right
}

int countIslands(vector<vector<int>>& matrix) {
    int rows = matrix.size();
    int cols = matrix[0].size();

    int count = 0;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (matrix[i][j] == 1) {
                count++;
                dfs(matrix, i, j);
            }
        }
    }

    return count;
}

int main() {
    vector<vector<int>> matrix = {
        {1, 1, 1, 1, 0},
        {1, 1, 0, 1, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    int numIslands = countIslands(matrix);
    cout << "Number of islands: " << numIslands << endl;

    return 0;
}

