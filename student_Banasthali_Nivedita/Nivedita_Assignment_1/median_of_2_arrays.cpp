/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
*/

#include <iostream>
#include <vector>
using namespace std;

double medianOfArrays(vector<int>& nums1, vector<int>& nums2) {
    int m = nums1.size();
    int n = nums2.size();
    int total = m + n;

    int i = 0, j = 0;
    int prev = 0, curr = 0;

    for (int k = 0; k <= total / 2; ++k) {
        prev = curr;
        if (i < m && (j >= n || nums1[i] <= nums2[j])) {
            curr = nums1[i];
            i++;
        } else {
            curr = nums2[j];
            j++;
        }
    }

    if (total % 2 == 0) {
        return (prev + curr) / 2.0;
    } else {
        return curr;
    }
}

int main() {
	
	int nums1[] = {1,2};    
    vector<int> n1(nums1, nums1 + sizeof(nums1) / sizeof(nums1[0]));
    
    int nums2[] = {3,4};
    vector<int> n2(nums2, nums2 + sizeof(nums2) / sizeof(nums2[0]));

    double median = medianOfArrays(n1, n2);

    cout << "Median: " << median << endl;

    return 0;
}

