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
        
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            }
            else head = head.next;
        }
        
        return dummyHead.next;
    }
}
