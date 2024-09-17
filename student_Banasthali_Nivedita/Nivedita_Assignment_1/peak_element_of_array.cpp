/*
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return
the index to any of the peaks.
*/

#include<iostream>
using namespace std;

int peakElement(int arr[], int n){
	int low = 0;
	int high = n-1;
	
	while(low <= high){
		
		int mid = low+(high-low)/2; //to avoid integer overflow
		
		//check if mid index in not the first or last index
		if(mid>0 && mid<n-1){
			
			//mid element is greater than its neighbors
			if((arr[mid] > arr[mid+1]) && (arr[mid] > arr[mid-1])){
				return mid;
			}
			
			//if left element greater than mid element, traverse left array
			else if(arr[mid-1] > arr[mid]){
				high = mid-1;
			}
			
			//if right element greater than mid element, traverse right array
			else{
				low = mid+1;
			}
		}
		
		
		//check for corner conditions
		
		//if mid is the first element of array
		else if(mid==0){
			if(arr[mid] > arr[mid+1]){
				return 0;
			}
			else{
				return 1;
			}
		}
		
		//if mid is the last element of array
		else if(mid==n-1){
			if(arr[mid] > arr[mid-1]){
				return n-1;
			}
			else{
				return n-2;
			}
		}
	}
	
}

int main(){
	int nums[] = {1,2,1,3,5,6,4};
	int n = sizeof(nums)/sizeof(nums[0]);

	int peak = peakElement(nums,n);
	
	cout<<"index of peak element of array = "<<peak<<endl;
	cout<<"Peak element is : "<<nums[peak];

	
}

