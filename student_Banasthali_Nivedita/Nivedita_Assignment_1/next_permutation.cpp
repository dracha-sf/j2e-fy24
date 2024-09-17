/*
Next Permutatiom
*/

#include<iostream>
#include<algorithm>

using namespace std;

void nextPermutation(int arr[], int n){
	
	//if single element is present in array
	if(n==1){
		return;
	}
	
	int index1;
	
	//find the break point of array
	for(int i=n-2; i>=0; i--){
		if(arr[i]<arr[i+1]){
			index1 = i;
			break;
		}
	}
	
	
	//if there is no breakpoint, i.e. the array is sorted in decreasing order, simply reverse it to get the next permutation
	if(index1<0){
		reverse(arr, arr+n);
	}
	
	//else, find the first number greater than breakpoint and swap the second number and the breakpoint number
	else{
		int index2 = 0;
		for(int i=n-1;i>=0;i--){
			if(arr[i]>arr[index1]){
				index2 = i;
				break;
			}
		}
		
		//swapping
		swap(arr[index1], arr[index2]);
		
		
		// sort the remaining array elements in ascending order
		sort(arr+index1+1, arr+n);
	}
}

int main(){
	
	int arr[] = {1,2,3};
	int n = sizeof(arr)/sizeof(arr[0]);
	
	nextPermutation(arr,n);
	
	for(int i = 0;i<n;i++){
		cout<<arr[i]<<" ";
	}
}
