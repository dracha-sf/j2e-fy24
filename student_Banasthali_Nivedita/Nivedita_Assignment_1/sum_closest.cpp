/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to
target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
*/

#include <iostream>
#include <algorithm>

using namespace std;

int threeSumClosest(int nums[], int n, int target) {
    int closestSum = 0;
    int minDiff = INT_MAX;
    
    sort(nums, nums + n); // Sort the array in ascending order
    
    //Using the two pointer approach
    for (int i = 0; i < n - 2; i++) {
        int left = i + 1;
        int right = n - 1;
        
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            int diff = abs(sum - target);
            
            if (diff < minDiff) {
                minDiff = diff;
                closestSum = sum;
            }
            
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    return closestSum;
}

int main() {
    int nums[] = {0,0,0};
    int n = sizeof(nums) / sizeof(nums[0]);
    int target = 1;
    
    int closestSum = threeSumClosest(nums, n, target);
    cout << "Closest sum to the target: " << closestSum << endl;
    
    return 0;
}

