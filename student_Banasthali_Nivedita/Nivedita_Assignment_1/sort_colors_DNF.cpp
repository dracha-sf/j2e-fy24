/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are
adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
*/

#include<iostream>
using namespace std;

void swap(int arr[], int i, int j){
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

int sortClr(int arr[],int n){
	//initialize all three pointers
	int low = 0;
	int mid = 0;
	int high = n-1;
	
	//unsorted array between mid and high
	while(mid <= high){
		
		//if arr[mid]==0 (mid element of array), swap low and mid, increment low and mid
		if(arr[mid] == 0){
			swap(arr, low, mid);
			mid++;
			low++;
		}
		
		//if arr[mid]==1, increment mid
		else if(arr[mid] == 1){
			mid++;
		}
		
		//if arr[mid]==2, swap mid and high, decrement high 
		else{
			swap(arr, high, mid);
			high--;
		}
	}
	
}

int main(){
	int nums[] = {2,0,2,1,1,0};
	int n = sizeof(nums)/sizeof(nums[0]);
	
	sortClr(nums,n);
	
	for(int i = 0;i<n;i++){
		cout<<nums[i]<<" ";
	}
}
