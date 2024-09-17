/*
Single Number
*/

#include<bits/stdc++.h>
using namespace std;

int singleNumber(const vector<int>& A) {
    int result = 0;

    for (int i = 0; i < 32; i++) {
        int count = 0;

        // Count the number of occurrences of the bit at position i
        for (int num : A) {
            if ((num >> i) & 1) {
                count++;
            }
        }

        // If the count is not divisible by 3, set the bit in the result
        if (count % 3 != 0) {
            result |= (1 << i);
        }
    }

    return result;
}

int main() {
    vector<int> A;

    // Example 1
    A = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
    int result1 = singleNumber(A);
    cout << "Example 1: " << result1 << endl;
    
    return 0;
}

