/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* The recursive solution. */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode next = removeElements(head.next, val);
        if (head.val == val) {
            return next;
        } else {
            head.next = next;
        }
        return head;
    }
}
