/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<TreeNode>> levelOrderBottom(TreeNode root) {
	   List<TreeNode> level = new LinkedList<TreeNode>();
	   LinkedList<List<Integer>> traversal = new LinkedList<List<Integer>>();

	   if (root != null) level.add(root);

	   while (!level.isEmpty()) {
		   LinkedList nextLevel = new LinkedList<TreeNode>();
		   LinkedList levelOfVal = new LinkedList<Integer>();
		   
		   for (TreeNode node : level) {
			   levelOfVal.add(node.val);
			   if (node.left != null)  nextLevel.add(node.left);
			   if (node.right != null) nextLevel.add(node.right);
		   }

		   traversal.addFirst(levelOfVal);
		   
		   level = nextLevel;
	   }

	   return traversal;
		  
    }
}
