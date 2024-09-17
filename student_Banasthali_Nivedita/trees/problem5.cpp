/*
Merge Two Binary Trees
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

TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
    if (root1 == NULL)
        return root2;
    if (root2 == NULL)
        return root1;

    TreeNode* mergedRoot = new TreeNode(root1->val + root2->val);
    mergedRoot->left = mergeTrees(root1->left, root2->left);
    mergedRoot->right = mergeTrees(root1->right, root2->right);

    return mergedRoot;
}


// print the binary tree in preorder traversal
void printTree(TreeNode* root) {
    if (root == NULL)
        return;

    std::cout << root->val << " ";
    printTree(root->left);
    printTree(root->right);
}

int main() {
    // Create the binary trees
    TreeNode* root1 = new TreeNode(1);
    root1->left = new TreeNode(3);
    root1->right = new TreeNode(2);
    root1->left->left = new TreeNode(5);

    TreeNode* root2 = new TreeNode(2);
    root2->left = new TreeNode(1);
    root2->right = new TreeNode(3);
    root2->left->right = new TreeNode(4);
    root2->right->right = new TreeNode(7);

    TreeNode* mergedRoot = mergeTrees(root1, root2);

   	cout << "Merged tree: ";
    printTree(mergedRoot);
    cout << endl;

    return 0;
}

