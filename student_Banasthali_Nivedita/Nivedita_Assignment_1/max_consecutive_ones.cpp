/*
Max number of consecutve 1's in a binary array
*/

#include<iostream>
using namespace std;

int max_Ones(int nums[], int n){
	int count = 0;
	int maxi = 0;
	
	for(int i=0;i<n;i++){
		if(nums[i]==1){
			count++;
			//maxi = max(maxi,count);
		}
		else{
			count = 0;
		}
		
		maxi = max(maxi,count);
	}
	
	return maxi;
}

int main(){
	int nums[] = {1,0,1,1,0,1};
	int n = sizeof(nums)/sizeof(nums[0]);
	
	int maxOnes = max_Ones(nums,n);
	cout<<"the max number of consecutive ones  = "<<maxOnes;
}
