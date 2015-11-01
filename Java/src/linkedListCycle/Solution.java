/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Status: Accepted.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // precondition: head is not null
        if (head == null) {
            return false;
        }

        ListNode tortoise = head;
        ListNode hare = head;

        boolean started = false;
   
        while (hare != null && hare.next != null) {
            // Be very caureful not to compare the value.
            if (started && hare == tortoise) {
                return true;
            }
            started = true;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        return false;
    }
}
