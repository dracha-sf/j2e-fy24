/*
Implement a function to find the minimum number of steps required to reach the end of an array of non-negative
integers, where each element of the array represents the maximum number of steps that can be taken forward from
that position.
*/

#include<bits/stdc++.h>

using namespace std;

int minStepsToEnd(vector<int>& nums) {
    int n = nums.size();
    
    //INT_MAX
    vector<int> dp(n, numeric_limits<int>::max());
    dp[0] = 0;

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (j + nums[j] >= i) {
                dp[i] = min(dp[i], dp[j] + 1);
            }
        }
    }

    return dp[n - 1];
}

int main() {
    vector<int> nums = {2, 3, 1, 1, 4};
    int minSteps = minStepsToEnd(nums);
    cout << "Minimum number of steps: " << minSteps << endl;

    return 0;
}

