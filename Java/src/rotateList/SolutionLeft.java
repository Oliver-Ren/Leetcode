/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode current = head;
        for (int i = 0; i < k; i++) {
            current = current.next;
            if (current == null || current.next == null) {
                return head;
            }
        }
        
        ListNode cutOffPoint = current;
        
        while (current.next != null) {
            current = current.next;
        }
    
        current.next = head;
        ListNode newHead = cutOffPoint.next;
        cutOffPoint.next = null;
        
        return newHead;

    }
    
}
