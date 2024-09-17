/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
You must solve it in O(n) time complexity.
*/

#include <iostream>
#include <vector>

using namespace std;

int partition(vector<int>& nums, int left, int right) {
    int p = nums[right];
    int i = left - 1;

    for (int j = left; j < right; ++j) {
        if (nums[j] <= p) {
            i++;
            swap(nums[i], nums[j]);
        }
    }

    swap(nums[i + 1], nums[right]);
    return i + 1;
}

int findKthLargest(vector<int>& nums, int k) {
    int left = 0;
    int right = nums.size() - 1;

    while (true) {
        int pivotIndex = partition(nums, left, right);
        int kthLargestIndex = nums.size() - k;

        if (pivotIndex == kthLargestIndex) {
            return nums[pivotIndex];
        } else if (pivotIndex < kthLargestIndex) {
            left = pivotIndex + 1;
        } else {
            right = pivotIndex - 1;
        }
    }
}

int main() {
	
	int nums[] = {3,2,3,1,2,4,5,5,6};
    vector<int> n(nums, nums+sizeof(nums)/sizeof(nums[0]));
    int k = 4;

    int result = findKthLargest(n, k);

	cout << "Kth largest element: " << result << endl;

    return 0;
}

