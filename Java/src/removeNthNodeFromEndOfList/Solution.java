/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
 * the two pointers approach.
 * Time complexity: O(n);
 * Space complexity: O(n);
 * Status: Accepted.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = dummyHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
    
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
