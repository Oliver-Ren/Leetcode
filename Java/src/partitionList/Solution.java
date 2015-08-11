/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* Ststus: Accepted, 324ms. */

public class Solution {
    public ListNode partition(ListNode head, int x) {
        while (true) {
            
            ListNode ptr1 = head;
            while (ptr1 != null &&
                    (ptr1.val < x || ptr1.next != null 
                     && ptr1.val >= x && ptr1.next.val >=x)) {
                ptr1 = ptr1.next;
            }


            if (ptr1 != null && ptr1.next != null) {
                int temp = ptr1.val;
                ptr1.val = ptr1.next.val;
                ptr1.next.val = temp;
            } else {
                break;
            }
        }

        return head;
    }
}

           
            
