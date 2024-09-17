/*
Hamming distance
*/

#include<bits/stdc++.h>
using namespace std;

int hammingDistance(int x, int y) {
    int distance = 0;
    int xorValue = x ^ y;

    while (xorValue > 0) {
        if (xorValue & 1) {
            distance++;
        }
        xorValue >>= 1;
    }

    return distance;
}

int main() {
    int x, y;

    // Example 1
    x = 1;
    y = 4;
    int result1 = hammingDistance(x, y);
    cout << "Example 1: " << result1 << endl;

    return 0;
}

