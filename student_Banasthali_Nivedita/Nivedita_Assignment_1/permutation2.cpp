/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

void backtrack(vector<vector<int> >& result, vector<int>& nums, vector<bool>& used, vector<int>& current) {
    if (current.size() == nums.size()) {
        result.push_back(current);
        return;
    }

    for (int i = 0; i < nums.size(); ++i) {
        if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
            continue;

        used[i] = true;
        current.push_back(nums[i]);
        backtrack(result, nums, used, current);
        current.pop_back();
        used[i] = false;
    }
}

vector<vector<int> > permuteUnique(vector<int>& nums) {
    vector<vector<int> > result;
    sort(nums.begin(), nums.end());

    vector<bool> used(nums.size(), false);
    vector<int> current;
    backtrack(result, nums, used, current);

    return result;
}

int main() {
    int nums[] = {1,2,3};
    int size = sizeof(nums) / sizeof(nums[0]);
    vector<int> numsVec(nums, nums + size);

    vector<vector<int> > result = permuteUnique(numsVec);

    for (int i = 0; i < result.size(); ++i) {
    	const vector<int>& permutation = result[i];
        cout << "[";
        for (int i = 0; i < permutation.size(); ++i) {
            cout << permutation[i];
            if (i != permutation.size() - 1)
                cout << ",";
        }
        cout << "]" << endl;
    }

    return 0;
}

