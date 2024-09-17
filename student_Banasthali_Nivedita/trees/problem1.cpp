/*
 Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/
#include <iostream>
using namespace std;

// Definition for a binary tree node
struct TreeNode {
    int val;
    TreeNode* left = NULL;
    TreeNode* right = NULL;
	//TreeNode* val;
    TreeNode(int x) : val(x){}
};

bool isSameTree(TreeNode* p, TreeNode* q) {
    if (p == NULL && q == NULL)
        return true;
    if (p == NULL || q == NULL)
        return false;
    if (p->val != q->val)
        return false;

    return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
}


int main() {
    // Create the first binary tree (p)
    TreeNode* p = new TreeNode(1);
    p->left = new TreeNode(2);
    p->right = new TreeNode(3);

    // Create the second binary tree (q)
    TreeNode* q = new TreeNode(1);
    q->left = new TreeNode(2);
    q->right = new TreeNode(3);

    bool isSame = isSameTree(p, q);
    
    if(isSame == 1){
    	cout<<"True";
	}else{
		cout<<"False";
	}
	
    return 0;
}


