/*
There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of
candies the i th kid has, and an integer extraCandies, denoting the number of extra candies that you have.
Return a boolean array result of length n, where result[i] is true if, after giving the i th kid all the extraCandies,
they will have the greatest number of candies among all the kids, or false otherwise.
Note that multiple kids can have the greatest number of candies.
*/

#include<iostream>
#define maxSize 20

using namespace std;

int main(){
	
	int candies[maxSize], n, extraCandies, maxCandies, i;
	bool res[maxSize];
	
	maxCandies = 0;
	
	cout<<"Enter number of kids : ";
	cin>>n;
	
	cout<<"\nEnter number of candies corresponding to each kid : ";
	for(i=0;i<n;i++){
		cin>>candies[i];
	}
	
	cout<<"\nThe candies corresponding to each kid are -\n";
	for(i=0;i<n;i++){
		cout<<(i+1)<<" ";
	}
	cout<<endl;
	for(i=0;i<n;i++){
		cout<<candies[i]<<" ";
	}
	
	cout<<"\nEnter number of extra candies : ";
	cin>>extraCandies;
	
	for(i=0;i<n;i++){
		maxCandies = max(candies[i],maxCandies);
	}
	
	for(i=0;i<n;i++){
		res[i] = (candies[i] + extraCandies >= maxCandies);
	}
	
	cout<<"\nThe outpur array is -\n";
	
	for(i=0;i<n;i++){
		if(res[i]==true){
        	cout<<"true ";
		}
		else{
			cout<<"false ";
		}
	}
}

