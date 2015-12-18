/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Status; Accepted.
public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode curr, ListNode prev) {
        // base case
        if (curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;

        return reverseList(next, curr);
    }
}

