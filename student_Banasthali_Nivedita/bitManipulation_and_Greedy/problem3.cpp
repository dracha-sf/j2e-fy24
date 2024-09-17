/*
There are n boxes with different quantities of candies in each of them. The ??-th box has ???? candies inside. You also
have n friends that you want to give the candies to, so you decided to give each friend a box of candies. But, you
don't want any friends to get upset so you decided to eat some (possibly none) candies from each box so that all
boxes have the same quantity of candies in them.
Note that you may eat a different number of candies from different boxes and you cannot add candies to any of the
boxes.
What's the minimum total number of candies you have to eat to satisfy the requirements?
*/

#include<bits/stdc++.h>
using namespace std;

int minimumCandies(int n, vector<int>& a) {
    
    int totalCandies = 0;
    
	for (int i = 0; i < n; i++) {
        totalCandies += a[i];
    }

   
    int targetCandies = totalCandies / n;

   
    int minCandiesToEat = 0;
    
    for (int i = 0; i < n; i++) {
        if (a[i] > targetCandies) {
            minCandiesToEat += a[i] - targetCandies;
        }
    }

    return minCandiesToEat;
}

int main() {
    int n = 10;
   
    vector<int> a{1,2,3,5,1,2,7,9,13,5};
    

    int minCandiesToEat = minimumCandies(n, a);
    cout << "Minimum total number of candies to eat: " << minCandiesToEat << endl;

    return 0;
}

