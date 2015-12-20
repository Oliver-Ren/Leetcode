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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // precondition: 0 <= m <= n < List.length
        if (m <= 0 || n < m) throw new IllegalArgumentException();

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode beforeRvs = dummyHead; 
        for (int i = 1; i < m; i++) {
            head = head.next;       
            beforeRvs = beforeRvs.next;
        }
        
        ListNode start = head;
        ListNode prev = beforeRvs;
        for (int i = m; i <= n; i++) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        start.next = head;
        beforeRvs.next = prev;
        
        return dummyHead.next;
    }
}
