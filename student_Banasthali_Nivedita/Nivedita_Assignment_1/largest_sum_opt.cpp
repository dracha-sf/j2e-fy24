/*
Given an integer array nums, find the subarray with the largest sum, and return its sum (Kadane's Algorithm)
*/

#include<iostream>
using namespace std;

int maxSubarraySum(int nums[],int n){
	int maxSum = INT_MIN;
	int sum = 0;
	
	int subStart = 0;//start index of subarray giving largest sum
	int start = -1, end = -1;//two pointers
	
	for(int i=0;i<n;i++){
		
		if(sum == 0){
			subStart = i;
		}
		
		//update sum
		sum = sum+nums[i];
		
		//update maxSum
		//maxSum = max(maxSum,sum);
		
		if(sum > maxSum){
			maxSum = sum;
			
			start = subStart;
			end = i;
		}
		
		//remove negative sum
		if(sum<0){
			sum = 0;
		}
	}
	
	cout<<"Subarray giving largest sum -"<<endl;
	for(int i = start;i <= end;i++){
		cout<<nums[i]<<" ";
	}
	
	return maxSum;
}

int main(){
	int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
	int n = sizeof(nums)/sizeof(nums[0]);
	
	//maxSubarraySum(nums,n);
	
	int maxSum = maxSubarraySum(nums,n);
	
	cout<<"\n\nSum of largest subarray  = "<<maxSum;
}
