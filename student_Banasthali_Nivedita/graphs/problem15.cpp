/*
15. Implement a function to find the number of ways to decode a message encoded as a string of digits, where each
digit can be mapped to a character in the alphabet (1 ? 'A', 2 ? 'B', ..., 26 ? 'Z').
Example:
Input:
s = "226"
Output:

*/

#include<bits/stdc++.h>

using namespace std;

int numDecodings(string s) {
    int n = s.length();

    vector<int> dp(n + 1, 0);

    // Base cases
    dp[0] = 1; // Empty string -->1 decoding
    if(dp[1] = (s[0] == '0') ){
    	return 0;
	}else{
		return 1;
	}
	

    for (int i = 2; i <= n; i++) {
        // Check if single digit decoding is possible
        int singleDigit = stoi(s.substr(i - 1, 1));
        if (singleDigit >= 1 && singleDigit <= 9) {
            dp[i] += dp[i - 1];
        }

        // Check if two-digit decoding is possible
        int twoDigits = stoi(s.substr(i - 2, 2));
        if (twoDigits >= 10 && twoDigits <= 26) {
            dp[i] += dp[i - 2];
        }
    }

    return dp[n];
}

int main() {
    string s = "226";
    int numWays = numDecodings(s);
    cout << "Number of ways to decode the message: " << numWays << endl;

    return 0;
}

