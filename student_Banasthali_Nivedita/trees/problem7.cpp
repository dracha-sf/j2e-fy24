/*
Kth smallest element in BST
*/

#include <iostream>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left = NULL;
    TreeNode* right = NULL;
    TreeNode(int x) : val(x) {}
};

int kthSmallest(TreeNode* root, int k) {
    stack<TreeNode*> st;
    TreeNode* curr = root;
    
    while (curr != NULL || !st.empty()) {
        while (curr != NULL) {
            st.push(curr);
            curr = curr->left;
        }
        
        curr = st.top();
        st.pop();
        
        k--;
        if (k == 0) {
            return curr->val;
        }
        
        curr = curr->right;
    }
    
    return -1; // In case k is invalid or tree is empty
}

int main() {
    // Create the binary search tree
    TreeNode* root = new TreeNode(5);
    root->left = new TreeNode(3);
    root->right = new TreeNode(6);
    root->left->left = new TreeNode(2);
    root->left->right = new TreeNode(4);
    root->left->left->left = new TreeNode(1);

    int k = 3;
    int result = kthSmallest(root, k);
    cout << "The " << k << "th smallest element is: " << result << endl;

    return 0;
}

