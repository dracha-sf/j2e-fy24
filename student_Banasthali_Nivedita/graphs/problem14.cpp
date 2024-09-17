/*
4. Implement a function to find the minimum number of swaps required to sort an array of integers in nondecreasing order.
*/

#include<bits/stdc++.h>

using namespace std;

int minSwaps(vector<int>& nums) {
    int n = nums.size();
    vector<pair<int, int>> arr(n);

    for (int i = 0; i < n; i++) {
        arr[i] = {nums[i], i};
    }

    // Sort the pair array based on the numbers
    sort(arr.begin(), arr.end());

    vector<bool> visited(n, false);
    int minSwaps = 0;

    for (int i = 0; i < n; i++) {
        if (visited[i] || arr[i].second == i) {
            continue;
        }

        int cycleSize = 0;
        int j = i;

        // Find the size of the cycle
        while (!visited[j]) {
            visited[j] = true;
            j = arr[j].second;
            cycleSize++;
        }

        // Update the minimum swaps required
        minSwaps += (cycleSize - 1);
    }

    return minSwaps;
}

int main() {
    vector<int> nums = {4, 3, 1, 2};
    int minSwaps = minSwaps(nums);
    cout << "Minimum number of swaps: " << minSwaps << endl;

    return 0;
}

