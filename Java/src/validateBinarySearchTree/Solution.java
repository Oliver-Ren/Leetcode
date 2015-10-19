/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/** 
 * Recursive Solution.
 * Time complexity: O(n) where n is the total number of nodes. 
 * Space Complexity: O(logn) for recursive calls.
 * Status: Accepted.
 */
public class Solution {
 private static class Status {
        private boolean isValid;
        private int max;
        private int min;

        public Status(boolean valid, int max, int min) {
            isValid = valid;
            this.max = max;
            this.min = min;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return postOrder(root, root.val).isValid;
    }

    private Status postOrder(TreeNode x, int currVal) {
        if (x == null) {
            return null;
        }

        Status leftStatus = postOrder(x.left, currVal);
        Status rightStatus = postOrder(x.right, currVal); 
        
        boolean leftCond = true;
        boolean rightCond = true;
        int min = x.val;
        int max = x.val;

        if (leftStatus != null) {
            leftCond = (x.val > leftStatus.max) && (leftStatus.isValid);
            min = leftStatus.min;
        }

        if (rightStatus != null) {
            rightCond = (x.val < rightStatus.min) && (rightStatus.isValid);
            max = rightStatus.max;
        }
        
        //System.out.println("val: " + x.val + " status: " + (leftCond && rightCond));
        return new Status(leftCond && rightCond, max, min);
    }




        
}
