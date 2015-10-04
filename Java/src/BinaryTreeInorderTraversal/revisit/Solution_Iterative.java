package BinaryTreeInorderTraversal;

import java.util.List;
import java.util.ArrayList;



public class Solution_Recursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        TreeNode curr = root;
        
        while (curr != null || !nodeStack.isEmpty()) {
            while (curr.left != null) {
                nodeStack.push(curr.left);
                curr = curr.left;
            }

            result.add(curr.val);
            curr = curr.right;

                
