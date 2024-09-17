/*
Reverse Bits
*/

#include<bits/stdc++.h>
using namespace std;

unsigned int reverseBits(unsigned int A) {
    unsigned int result = 0;

    
    for (int i = 0; i < 32; i++) {
        if ((A & (1 << i)) != 0) {
            result |= (1 << (31 - i));
        }
    }

    return result;
}

int main() {
    unsigned int A;

    // Example 1
    A = 0;
    unsigned int result1 = reverseBits(A);
    cout << "Example 1: " << result1 << endl;

    return 0;
}

