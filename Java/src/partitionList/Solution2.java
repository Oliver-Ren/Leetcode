/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* time complexity: O(n)
 * space complexity: O(1)
 * STatus: Accepted, 332ms.
 */ 

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftStart = left;
        ListNode rightStart = right;

        for (ListNode current = head; current != null; current = current.next) {
            if (current.val < x) {
                left.next = current;
                left = current;
            } else {
                right.next = current;
                right = current;
            }
        }

        left.next = rightStart.next;
        right.next = null;
        return leftStart.next;
    }
}

