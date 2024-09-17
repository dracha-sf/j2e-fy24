/*
Symmetric tree
*/

#include<iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left = NULL;
    TreeNode* right = NULL;
    TreeNode(int x) : val(x){}
};


bool isMirror(TreeNode* p, TreeNode* q) {
    if (p == NULL && q == NULL)
        return true;
    if (p == NULL || q == NULL )
        return false;
    if (p->val != q->val)
        return false;

    return isMirror(p->left, q->right) && isMirror(p->right, q->left);
}

bool isSymmetric(TreeNode* root) {
    if (root == NULL)
        return true;
    
    return isMirror(root->left, root->right);
}


int main() {
    // Create the binary tree
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(2);
    root->left->left = new TreeNode(NULL);
    root->left->right = new TreeNode(3);
    root->right->left = new TreeNode(NULL);
    root->right->right = new TreeNode(3);

    bool isSym = isSymmetric(root);
    
    if(isSym == 1){
    	cout<<"True";
	}else{
		cout<<"False";
	}

    return 0;
}
