/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* The basic idea is using the binary
 * tree inorder travesal. And the inorder
 * traversal is implemented using the
 * iterative way.
 * the average time complexity of the 
 * hasNext() and next() method is O(1)
 * the space complexity is O(logn).
 * Status: Accepted.
 */

public class BSTIterator {
    Stack<TreeNode> nodeStack;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        nodeStack = new Stack<TreeNode>();
        goToLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
       return !nodeStack.empty(); 
    }

    /** @return the next smallest number */
    public int next() {
        curr = nodeStack.pop();
        goToLeft(curr.right);
        return curr.val;

    }

    /** traverse the node to the left most child
      * of current node. 
      * Precondition: the root is not null. */
    private void goToLeft(TreeNode root) {
        while (root != null) {
            nodeStack.push(root);
            root = root.left;
        }
    }

}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
