/*
2. Implement a function to find the minimum number of swaps required to sort an array using graph theory.

*/

#include<bits/stdc++.h>

using namespace std;

int min_swaps(vector<int>& arr) {
    int n = arr.size();
    vector<pair<int, int>> indexedArr(n);

    // Create an array to store the original indices of the array elements
    for (int i = 0; i < n; i++) {
        indexedArr[i] = make_pair(arr[i], i);
    }

    // Sort the array 
    sort(indexedArr.begin(), indexedArr.end());

    vector<bool> visited(n, false);
    int swaps = 0;

    for (int i = 0; i < n; i++) {
        // If the element is already visited or in the correct position, continue to the next element
        if (visited[i] || indexedArr[i].second == i) {
            continue;
        }

        int cycle_size = 0;
        int j = i;

        // Count size of cycle
        while (!visited[j]) {
            visited[j] = true;
            j = indexedArr[j].second;
            cycle_size++;
        }

        // Calculate the number of swaps required within the cycle
        if (cycle_size > 0) {
            swaps += (cycle_size - 1);
        }
    }

	//return number of swaps
    return swaps;
}

int main() {
    vector<int> arr = {5, 3, 8, 6, 7};

    int minSwaps = min_swaps(arr);
    cout << "Minimum number of swaps: " << minSwaps << endl;

    return 0;
}

