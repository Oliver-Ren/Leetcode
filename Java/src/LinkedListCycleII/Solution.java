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
        if (head == null ) return null;
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while ( fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                break;
            }
        }
        if (fastPointer == null || fastPointer.next == null) return null;
        slowPointer = head;
        while (fastPointer != slowPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return fastPointer;
       
    }
}
