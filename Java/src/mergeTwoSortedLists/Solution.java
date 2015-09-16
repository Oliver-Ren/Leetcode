/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
 * The iterative solution.
 * Time complexity: O(n)
 * space complexity: O(1)
 * status: Accepted, 316ms.
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode visitor = dummy;
        
        dummy.next = l1;

        while (l1 != null || l2 != null) {
            // condition when l1 is null
            if (l1 == null) {
                visitor.next = l2;
                break;
            }

            if (l2 == null) {
                visitor.next = l1;
                break;
            }

            if (l1.val < l2.val) {
                visitor.next = l1;
                l1 = l1.next;
            } else {
                visitor.next = l2;
                l2 = l2.next;
            }

            visitor = visitor.next;
        }

        return dummy.next;
        
    }
}
