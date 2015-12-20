/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        head = dummyHead;
        
        while (head != null) {
            ListNode curr = head.next;
            while (curr != null && curr.val == val) {
                curr = curr.next;
            }
            head.next = curr;
            head = head.next;
        }
        
        return dummyHead.next;
    }
}
