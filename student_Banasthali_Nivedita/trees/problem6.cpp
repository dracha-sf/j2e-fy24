/*
Validate Binary Search Tree
*/

#include <iostream>
#include <climits>
using namespace std;

// Definition for a binary tree node
struct TreeNode {
    int val;
    TreeNode* left = NULL;
    TreeNode* right = NULL;
    TreeNode(int x) : val(x){}
};


bool validateBST(TreeNode* root, long long lower, long long upper) {
    if (root == NULL)
        return true;

    if (root->val <= lower || root->val >= upper)
        return false;

    return validateBST(root->left, lower, root->val) && validateBST(root->right, root->val, upper);
}

bool isValidBST(TreeNode* root) {
    return validateBST(root, LONG_MIN, LONG_MAX);
}

int main() {
    // Create the binary tree
    TreeNode* root = new TreeNode(2);
    root->left = new TreeNode(1);
    root->right = new TreeNode(3);

    bool isValid = isValidBST(root);

   	if(isValid == 1){
   		cout<<"True";
	   }else{
	   	cout<<"False";
	   }
	   
    return 0;
}

