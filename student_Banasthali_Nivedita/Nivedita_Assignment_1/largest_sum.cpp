/*
Given an integer array nums, find the subarray with the largest sum, and return its sum (Brute Force)
*/
#include<iostream>
using namespace std;

int maximumSubarraySum(int arr[], int n) {
 int maxSum = INT_MIN;
 for(int i = 0; i <= n - 1; i++) {
   int currSum = 0;
   for (int j = i; j <= n - 1; j++) {
     currSum += arr[j];
     if (currSum > maxSum) {
       maxSum = currSum;
     }
   }
 }
 
 return maxSum;
 
}
int main() {
   // Your code goes here
   int a[] = {5,4,-1,7,8};
   int n = sizeof(a)/sizeof(a[0]);
   cout<<"Sum of maximum subarray = "<<maximumSubarraySum(a, n);
   return 0;
}
