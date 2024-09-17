/*
You have N pills of characteristic values [a1, a2…..an]
On each day i, you can take the ith pill and increase your health by ai points or Do nothing and take 1 point of
damage
H = H - 1, where H is a value denoting your health.
You die if your health becomes zero. Initially H = V (where V is a value given in the input).
What is the minimum number of pills you should take to survive for N days.
*/

#include<bits/stdc++.h>
using namespace std;

void generateSubsets(vector<int>& nums, int index, vector<int>& subset, vector<vector<int>>& subsets) {
	
    subsets.push_back(subset); 

    for (int i = index; i < nums.size(); i++) {
        subset.push_back(nums[i]);
        
        generateSubsets(nums, i + 1, subset, subsets);
        
		subset.pop_back();
    }
}

vector<vector<int>> subsets(vector<int>& nums) {
    vector<vector<int>> subsets;
    vector<int> subset;
    
    generateSubsets(nums, 0, subset, subsets);
    
	return subsets;
}

int main() {
    vector<int> nums;

    // Example 1
    nums = {1, 2, 3};
    vector<vector<int>> result1 = subsets(nums);
    cout << "Example 1: ";
    for (auto subset : result1) {
        cout << "[";
        for (int num : subset) {
            cout << num << " ";
        }
        cout << "]";
    }
    cout << endl;


    return 0;
}

