package BinaryTreeInorderTraversal;
import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

/* This is the iterative version of inorder
 * traversal, the tree structure will not 
 * be changed. The algorithm makes use ot 
 * the property of the inorder traversal.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> result = new LinkedList<Integer>();
         Stack<TreeNode> nodeStack = new Stack<TreeNode>();

         TreeNode curr = root;

         while (!nodeStack.empty() || curr != null) {
             while (curr != null) {
                 nodeStack.push(curr);
                 curr = curr.left;
             }

             curr = nodeStack.pop();
             result.add(curr.val);
             curr = curr.right;
         }


         return result;
    }
}
             
