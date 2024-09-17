/*
Convert Sorted Array to Balanced Binary Search Tree
*/
#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left = NULL;
    TreeNode* right = NULL;
    TreeNode(int x) : val(x){}
};

TreeNode* sortedArrayToBST(vector<int>& nums, int start, int end) {
    if (start > end) {
        return NULL;
    }

    int mid = start + (end - start) / 2;
    TreeNode* root = new TreeNode(nums[mid]);

    root->left = sortedArrayToBST(nums, start, mid - 1);
    root->right = sortedArrayToBST(nums, mid + 1, end);

    return root;
}

TreeNode* sortedArrayToBST(vector<int>& nums) {
    return sortedArrayToBST(nums, 0, nums.size() - 1);
}

void printInorder(TreeNode* root) {
    if (root == NULL) {
        return;
    }

    printInorder(root->left);
    cout << root->val << " ";
    printInorder(root->right);
}

int main() {
    vector<int> nums = {-10, -3, 0, 5, 9};
    
    TreeNode* root = sortedArrayToBST(nums);

    printInorder(root);
    cout << endl;

    return 0;
}

