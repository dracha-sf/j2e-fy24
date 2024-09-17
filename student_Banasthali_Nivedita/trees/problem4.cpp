/*
Balanced Binary Tree
*/

#include <iostream>
#include <cmath>
using namespace std;

// Definition for a binary tree node
struct TreeNode {
    int val;
    TreeNode* left = NULL;
    TreeNode* right = NULL;

    TreeNode(int x) : val(x){}
};

int checkHeight(TreeNode* root) {
    if (root == NULL)
        return 0;

    int leftHeight = checkHeight(root->left);
    if (leftHeight == -1)
        return -1;

    int rightHeight = checkHeight(root->right);
    if (rightHeight == -1)
        return -1;

    if (abs(leftHeight - rightHeight) > 1)
        return -1;

    return max(leftHeight, rightHeight) + 1;
}

bool isBalanced(TreeNode* root) {
    return checkHeight(root) != -1;
}

int main() {
    // Create the binary tree
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(2);
    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(3);
    root->left->left->left = new TreeNode(4);
    root->left->left->right = new TreeNode(4);

    bool isBal = isBalanced(root);
    
    if(isBal==1){
    	cout<<"True";
	}else{
		cout<<"False";
	}

    return 0;
}

