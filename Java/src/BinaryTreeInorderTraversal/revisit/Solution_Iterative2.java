package BinaryTreeInorderTraversal;

import java.util.List;
import java.util.ArrayList;

/**
 * The iterative solution
 * which will change the 
 * structure of the original
 * tree.
 */

public class Solution_Iterative2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();

        TreeNode curr = root;
       
        
