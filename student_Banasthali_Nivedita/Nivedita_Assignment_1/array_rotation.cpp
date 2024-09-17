/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it
is not in nums.
You must write an algorithm with O(log n) runtime complexity
*/

#include <iostream>
using namespace std;

int search(int nums[], int size, int target) {
	
    int left = 0;
    int right = size - 1;

    while (left <= right) {
    	
        int mid = left + (right - left) / 2;

        if (nums[mid] == target)
            return mid;

        // Check if the left half is sorted
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        // Otherwise, the right half is sorted
        else {
            if (target > nums[mid] && target <= nums[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
    }

    return -1;  // Target not found
}

int main() {
    int nums[] = {4,5,6,7,0,1,2};
    int size = sizeof(nums) / sizeof(nums[0]);
    
    int target = 3;
    
	int result = search(nums, size, target);
    cout <<result;
}

