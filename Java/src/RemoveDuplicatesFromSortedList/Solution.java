package RemoveDuplicatesFromSortedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode next = head;
        while (next != null && next.next != null) {
            if (next.val == next.next.val) {
                next.next = next.next.next;
            }
            else next = next.next;
        }
        return head;
    }
}
*/