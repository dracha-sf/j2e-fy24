/*
Inverted binary tree
*/
#include <iostream>
using namespace std;

// Definition for a binary tree node
struct TreeNode {
    int val;
    TreeNode* left = NULL;
    TreeNode* right = NULL;
    TreeNode(int x) : val(x){}
};

TreeNode* invertTree(TreeNode* root) {
    if (root == NULL)
        return NULL;

    // Swap left and right subtrees recursively
    TreeNode* temp = root->left;
    root->left = invertTree(root->right);
    root->right = invertTree(temp);

    return root;
}


// Function to print the binary tree in preorder traversal
void printTree(TreeNode* root) {
    if (root == NULL)
        return;

    cout << root->val << " ";
    printTree(root->left);
    printTree(root->right);
}

int main() {
    // Create the binary tree
    TreeNode* root = new TreeNode(2);
    root->left = new TreeNode(1);
    root->right = new TreeNode(3);
    //root->left->left = new TreeNode(1);
    //root->left->right = new TreeNode(3);
    //root->right->left = new TreeNode(6);
    //root->right->right = new TreeNode(9);

    TreeNode* invertedRoot = invertTree(root);

    cout << "Inverted tree: ";
    printTree(invertedRoot);
    cout << endl;

    return 0;
}

