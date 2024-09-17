/*
Single Integer 2
*/
#include<bits/stdc++.h>
using namespace std;

int singleNumber(const vector<int>& A) {
    int result = 0;

    // XOR all the elements in the array
    for (int num : A) {
        result ^= num;
    }

    return result;
}

int main() {
    vector<int> A;

    // Example 1
    A = {1, 2, 2, 3, 1};
    int result1 = singleNumber(A);
    cout << "Example 1: " << result1 << endl;

    return 0;
}

