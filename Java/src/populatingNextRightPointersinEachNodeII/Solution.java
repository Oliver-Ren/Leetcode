/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	/* This is the shorter BFS approach which makes use of the linked-list
	   structure to achive e the O(1) space complexity. */
	public void connectBFS(TreeLinkNode root) {
		TreeLinkNode queue = root;
		while (queue != null) {
			TreeLinkNode level = new TreeLinkNode(0);
			TreeLinkNode current = level;

			while (queue != null) {
				if (queue.left != null) {
					current.next = queue.left;
					current = current.next;
				}

				if (queue.right != null) {
					current.next = queue.right;
					current = current.next;
				}

				queue = queue.next;
			}

			queue = level.next;
		}
	}





	/* This is my implementation of the iterative version of the problem. */
    public void connect(TreeLinkNode root) {
        /* The base case : the root is empty. */
		if (root == null) {
			return;
		}

		TreeLinkNode curr = root;


		while (curr != null) {
			TreeLinkNode leftMost = null;
			while (curr != null) {
				if (curr.left != null && curr.right != null) {
					/* Assign the leftmost node of this level. */
					leftMost = leftMost == null ? curr.left : leftMost;

					curr.left.next = curr.right;
					curr.right.next = findCousinOfChildIter(curr);
				} else if (curr.left != null && curr.right == null) {
					/* Assign the leftmore node of this level to be the left. */
					leftMost = leftMost == null ? curr.left : leftMost;

					curr.left.next = findCousinOfChildIter(curr);
				} else if (curr.right != null) {
					/* Assign the leftmost node of thie level to be the right. */
					leftMost = leftMost == null ? curr.right : leftMost;

					curr.right.next = findCousinOfChildIter(curr);
				}

				curr = curr.next;
			}

			curr = leftMost;
		}

    }

    private TreeLinkNode findCousinOfChildIter(TreeLinkNode root) {
		TreeLinkNode cousin = root.next;
		while (cousin != null) {
			if (cousin.left != null) {
				return cousin.left;
			} else if (cousin.right != null) {
				return cousin.right;
			}
			cousin = cousin.next;
		}
		return null;
	}






	/*================================================================*/
	/* This is the recursive version of the solution. it takes O(n) time
	 * but also takes O(n) space. */
    public void connect(TreeLinkNode root) {

       /* Base case: the bottom of the tree. */
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			return;
		} else if (root.left != null && root.right == null) {
			root.left.next = findCousinOfChild(root);
		} else if (root.left == null && root.right != null) {
			root.right.next = findCousinOfChild(root);
		} else if (root.left != null & root.right != null) {
			root.left.next = root.right;
			root.right.next = findCousinOfChild(root);
		}
		
		connect(root.right);
		connect(root.left);

    }

	private TreeLinkNode findCousinOfChild(TreeLinkNode root) {
		/* The condition where there is no cousin of the root. */
		if (root.next == null) {
			return null;
		}

		if (root.next.left != null) {
			return root.next.left;
		} else if (root.next.right != null) {
			return root.next.right;
		} else {
			return findCousinOfChild(root.next);
		}
	}


}
