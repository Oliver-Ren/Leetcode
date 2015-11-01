package LinkedListCycleII;

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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        boolean hasCycle = false;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (tortoise == hare) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            hare = head;
            while (hare != tortoise) {
                hare = hare.next;
                tortoise = tortoise.next;
            }
            return hare;
        }

        return null;
    }
}
