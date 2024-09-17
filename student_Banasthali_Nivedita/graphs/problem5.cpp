/*
5. Implement a function to find the kth smallest element in a matrix, where the matrix is sorted row-wise and columnwise
*/

#include<bits/stdc++.h>

using namespace std;

struct Element {
    int value;
    int row;
    int col;

    Element(int value, int row, int col) : value(value), row(row), col(col) {}

    bool operator>(const Element& other) const {
        return value > other.value;
    }
};

int kthSmallest(vector<vector<int>>& matrix, int k) {
    int rows = matrix.size();
    int cols = matrix[0].size();

    priority_queue<Element, vector<Element>, greater<Element>> minHeap;

    // Insert the first element of each row into the min-heap
    for (int i = 0; i < rows; i++) {
        minHeap.push(Element(matrix[i][0], i, 0));
    }

    // Extract the k-1 smallest elements from the min-heap
    for (int i = 0; i < k - 1; i++) {
        Element smallest = minHeap.top();
        minHeap.pop();

        // If the current element has a column index less than the last column,
        // insert the next element in the same row
        if (smallest.col < cols - 1) {
            minHeap.push(Element(matrix[smallest.row][smallest.col + 1], smallest.row, smallest.col + 1));
        }
    }

    // The kth smallest element will be the top of the min-heap
    return minHeap.top().value;
}

int main() {
    vector<vector<int>> matrix = {
        {1, 5, 9},
        {10, 11, 13},
        {12, 13, 15}
    };
    int k = 8;

    int kthSmallestElement = kthSmallest(matrix, k);
    cout << "Kth smallest element: " << kthSmallestElement << endl;

    return 0;
}

