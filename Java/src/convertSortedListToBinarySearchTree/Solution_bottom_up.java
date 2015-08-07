/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/** Time complexity: O(n)
  * Space complexity: O(n)
  * Status: accepted, 400ms.
  */

public class Solution {
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        this.current = head;
        ListNode pointer = head;
        int len = 0;
        while (pointer != null) {
            len++;
            pointer = pointer.next;
        }

        return constructBST(len);

        
    }


    private TreeNode constructBST(int len) {
        if (len == 0 ) {
            return null;
        }

        TreeNode left = constructBST(len / 2);
        
        TreeNode root = new TreeNode(current.val);
        current = current.next;

        root.left = left;
        root.right = constructBST(len - len / 2 - 1);
        return root;
    }
}


