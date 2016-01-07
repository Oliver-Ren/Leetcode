import java.util.List;
import java.util.LinkedList;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* Status: Accepted. */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode curr = head;
        boolean shouldDeleteCurr = false;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
                shouldDeleteCurr = true;
            } else {
                if (shouldDeleteCurr) {
                    prev.next = curr.next;
                    shouldDeleteCurr = false;
                    curr = prev.next;
                } else {
                    prev = prev.next;
                    curr = curr.next;
                }

            }
        }

        return dummyHead.next;
    }
}

