/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
array of the non-overlapping intervals that cover all the intervals in the input.
*/

#include <iostream>
#include <algorithm>
using namespace std;

void mergeIntervals(int intervals[][2], int size, int result[][2], int& resultSize) {
    // Sort intervals based on the start time
    sort(intervals, intervals + size, [](const int a[], const int b[]) {
        return a[0] < b[0];
    });

    int idx = 0;
    for (int i = 0; i < size; ++i) {
        if (idx == 0 || intervals[i][0] > result[idx - 1][1]) {
            // Non-overlapping interval
            result[idx][0] = intervals[i][0];
            result[idx][1] = intervals[i][1];
            idx++;
        } else {
            // Overlapping interval, merge with the previous one
            result[idx - 1][1] = max(result[idx - 1][1], intervals[i][1]);
        }
    }

    resultSize = idx;
}

int main() {
    int intervals[][2] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int size = sizeof(intervals) / sizeof(intervals[0]);

    int merged[size][2];
    int resultSize;

    mergeIntervals(intervals, size, merged, resultSize);

    // Print the merged intervals
    for (int i = 0; i < resultSize; ++i) {
        cout << "[" << merged[i][0] << "," << merged[i][1] << "]" << endl;
    }

    return 0;
}

