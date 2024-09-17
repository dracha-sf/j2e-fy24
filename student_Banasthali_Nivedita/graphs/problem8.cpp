/*
Given a binary tree, implement a function to find the maximum path sum, where a path is defined as any sequence
of nodes from some starting node to any node in the tree along the parent-child connections.

*/
#include<bits/stdc++.h>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

int maxPathSumUtil(TreeNode* root, int& maxSum) {
    // Base case
    if (root == nullptr) {
        return 0;
    }

    int leftSum = max(0, maxPathSumUtil(root->left, maxSum));
    int rightSum = max(0, maxPathSumUtil(root->right, maxSum));

    maxSum = max(maxSum, root->val + leftSum + rightSum);

    return max(root->val + leftSum, root->val + rightSum);
}

int maxPathSum(TreeNode* root) {
    int maxSum = numeric_limits<int>::min();
    maxPathSumUtil(root, maxSum);
    return maxSum;
}

int main() {
    // Create the binary tree
    TreeNode* root = new TreeNode(-10);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);
    root->right->left = new TreeNode(15);
    root->right->right = new TreeNode(7);

    int maxPath = maxPathSum(root);
    cout << "Maximum Path Sum: " << maxPath << endl;

    return 0;
}

