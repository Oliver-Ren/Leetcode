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

/* time complexity: O(nlogn);
 * space complexity: O(1);
 * stats: Accepted, 383ms.
 */

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return findMid(head, null); 
        
    }

    private TreeNode findMid(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }

        ListNode faster = start;
        ListNode slower = start;

        while (faster != end && faster.next != end) {
            faster = faster.next.next;
            slower = slower.next;
        }
        
        TreeNode root = new TreeNode(slower.val);
        root.left = findMid(start, slower);
        root.right = findMid(slower.next, end);
        return root;
    }

}
