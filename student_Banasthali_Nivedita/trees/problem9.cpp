/*
Range of BST
*/

#include <iostream>
#include <stack>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left = NULL;
    TreeNode* right = NULL;
    TreeNode(int x) : val(x){}
};

int rangeSumBST(TreeNode* root, int low, int high) {
    stack<TreeNode*> st;
    TreeNode* curr = root;
    int sum = 0;

    while (curr != NULL || !st.empty()) {
        while (curr != NULL) {
            st.push(curr);
            curr = curr->left;
        }

        curr = st.top();
        st.pop();

        if (curr->val >= low && curr->val <= high) {
            sum += curr->val;
        }

        curr = curr->right;
    }

    return sum;
}

int main() {
    // Create the binary search tree
    TreeNode* root = new TreeNode(10);
    root->left = new TreeNode(5);
    root->right = new TreeNode(15);
    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(7);
    root->right->right = new TreeNode(18);

    int low = 6;
    int high = 10;
    int result = rangeSumBST(root, low, high);
    cout << "The sum of values of nodes in the range [" << low << ", " << high << "] is: " << result << endl;

    return 0;
}

