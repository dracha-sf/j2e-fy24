/*
Search in a Binary Search Tree
*/
#include <iostream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left = NULL;
    TreeNode* right = NULL;
    TreeNode(int x) : val(x){}
};

TreeNode* searchBST(TreeNode* root, int val) {
    if (root == NULL || root->val == val) {
        return root;
    }

    if (val < root->val) {
        return searchBST(root->left, val);
    } else {
        return searchBST(root->right, val);
    }
}

void preorderTraversal(TreeNode* root) {
    if (root == NULL) {
        return;
    }

	cout << root->val << " ";
    preorderTraversal(root->left);
    preorderTraversal(root->right);
}

int main() {
    // Create the binary search tree
    TreeNode* root = new TreeNode(4);
    root->left = new TreeNode(2);
    root->right = new TreeNode(7);
    root->left->left = new TreeNode(1);
    root->left->right = new TreeNode(3);

    int val = 2;
    TreeNode* result = searchBST(root, val);

    cout << "The subtree rooted with the node having value " << val << " is: ";
    preorderTraversal(result);
    cout << endl;

    return 0;
}

