import java.util.Arrays;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* Status: Accepted. */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null
				|| inorder.length != postorder.length) {
			return null;
		}

		int len = inorder.length;

		return buildSubTree(inorder, postorder, 0, len, 0, len);
    }

	private TreeNode buildSubTree(int[] inorder, int[] postorder,
			int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart >= inEnd) {
			return null;
		}

		if (inStart == inEnd - 1) {
			return new TreeNode(inorder[inStart]);
		}

		int[] haha = {1, 3, 2};

		int rootVal = postorder[postEnd - 1];
		TreeNode root = new TreeNode(rootVal);
		System.out.println("ins:" + inStart + "inEn:" + inEnd + ", rootval:" + rootVal);
		int inorderIdx = linearSearch(inorder, inStart, inEnd, rootVal);
		System.out.println("indx:" + inorderIdx);
		int leftLen = inorderIdx - inStart;
		int rightLen = inEnd - inorderIdx - 1;
		root.left = buildSubTree(inorder, postorder, inStart, inorderIdx, postStart, postStart + leftLen);
		root.right = buildSubTree(inorder, postorder, inorderIdx + 1, inEnd, postStart + leftLen, postStart + leftLen + rightLen);
		return root; 
	}

	private int linearSearch(int[] nums, int start, int end, int target) {
		for (int i = start; i < end; i++) {
			if (nums[i] == target) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] in = {1, 3, 2};
		int[] post = {3, 2 ,1};
		test.buildTree(in, post);
	}
}
