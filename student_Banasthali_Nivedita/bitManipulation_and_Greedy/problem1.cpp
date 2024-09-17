/*
You are given N fruits.
The weight of the fruits is represented by an array A.
All those fruits which have the same weight can be sliced in one step.
Task:
Your task is to determine the number of steps to slice all the fruits.
*/

#include<bits/stdc++.h>

using namespace std;

int countSteps(int N, vector<int>& A) {
    
    unordered_map<int, int> freq;

    for (int i = 0; i < N; i++) {
        freq[A[i]]++;
    }

    // Sort the unique weights of the fruits in descending order
    vector<int> uniqueWeights;
    
	for (auto it = freq.begin(); it != freq.end(); ++it) {
        uniqueWeights.push_back(it->first);
    }
    
    sort(uniqueWeights.rbegin(), uniqueWeights.rend());

    //slicing steps
    int steps = 0;
    int remaining = N;
    
    for (int weight : uniqueWeights) {
        int count = freq[weight];
        steps++;
        remaining -= count;
    }

    return steps;
}

int main() {
    int N=4;
    
    vector<int> A{3,6,7,7};
    
    int steps = countSteps(N, A);
    cout << "Number of steps to slice all the fruits: " << steps << endl;

    return 0;
}

