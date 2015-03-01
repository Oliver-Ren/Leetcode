/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> postorderTraversal(TreeNode *root) {
        stack<TreeNode *> nodeStack;
        vector<int> result;
        if (root == nullptr) return result;
        nodeStack.push(root);
        TreeNode *curr;
        TreeNode *prev;
        while (!nodeStack.empty()) {
            curr = nodeStack.top();
            if (curr->left == nullptr && curr->right == nullptr
                || (prev != nullptr && (curr->left == prev || curr->right == prev))) {
                result.push_back(curr->val);
                nodeStack.pop();
                prev = curr;
            } else {
                if (curr->right != nullptr) {
                    nodeStack.push(curr->right);
                }
                
                if (curr->left != nullptr) {
                    nodeStack.push(curr->left);
                }
            }
        }
        return result;
    }

};