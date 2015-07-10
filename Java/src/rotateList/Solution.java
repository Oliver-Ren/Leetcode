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
        if (head == null || head.next == null) return head;
        ListNode current = head;
        int len = 1;
        
        while (current.next != null) {
            current = current.next;
            len++;
        }
        
        k = k % len;
        len = len - 1;
        if (k == 0) return head;
        current.next = head;
        current = head;
        
        
        while (len > k)  {
            current = current.next;
            len--;
        }
        
        ListNode newHead = current.next;
        current.next = null;
        return newHead;
    }
    
}
