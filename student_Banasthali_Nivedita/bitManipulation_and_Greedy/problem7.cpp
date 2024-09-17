/*
Min XOR value
*/

#include<bits/stdc++.h>
using namespace std;

int findMinXOR(const vector<int>& A) {
    int minXOR = INT_MAX;

    vector<int> sortedA = A;
    sort(sortedA.begin(), sortedA.end());

    // Compare adjacent elements and update the minimum XOR value
    for (int i = 0; i < sortedA.size() - 1; i++) {
        minXOR = min(minXOR, sortedA[i] ^ sortedA[i + 1]);
    }

    return minXOR;
}

int main() {
    vector<int> A;

    // Example 1
    A = {0, 2, 5, 7};
    int result1 = findMinXOR(A);
    cout << "Example 1: " << result1 << endl;

    return 0;
}

