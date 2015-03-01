/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 
 
 
 /** This is the stack solution, it will modify the orignial tree, each time */
class Solution2 {
public:
    vector<int> postorderTraversal(TreeNode *root) {
        stack<TreeNode *> nodeStack;
        vector<int> result;
        if (root == nullptr) return result;
        nodeStack.push(root);
        TreeNode *curr;
        while (!nodeStack.empty()) {
            curr = nodeStack.top();
            if (curr->left != nullptr) {
                nodeStack.push(curr->left);
                curr->left = nullptr;
            } else if (curr->right != nullptr) {
                nodeStack.push(curr->right);
                curr->right = nullptr;
            } else {
                result.push_back(curr->val);
                nodeStack.pop();
            }
            
        }
        return result;
    }
};