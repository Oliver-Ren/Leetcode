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
    public TreeNode invertTree(TreeNode root) {
		
		Queue<TreeNode> level = new LinkedList<TreeNode>();
		level.add(root);

		while (!level.isEmpty()) {
			TreeNode current = level.poll();
			if (current != null) {
				TreeNode temp = current.left;
				current.left = current.right;
				current.right = temp;
				level.add(current.left);
				level.add(current.right);
			}
		}

		return root;
			
    }

			
}
