/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* The third method:
 * using divide and conquer (recursive).
 * The merge is implemented in-place.
 * Time complexity: O(nklogk) where n is 
 * the length of the longest list.
 * Space complexity: O(1);
 * Status: Accepted, 360ms. 
 */

public class Solution_DC {

    public ListNode mergeKLists(ListNode[] lists) {
        // Dealing with corner case  inputs
        if (lists == null || lists.length == 0) {
            return null;
        }

        return divide(lists, 0, lists.length);

    }

    // Helper method for divide and conquer
    // start is inclusive and end is exclusive.
    private ListNode divide(ListNode[] lists, int start, int end) {
        if (end - start == 1) {
            return lists[start];
        }
        if (end - start == 2) {
            return mergeTwoLists(lists[start], lists[end - 1]);
        }

        int mid = start + (end - start) / 2;

        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid, end);
        
        return mergeTwoLists(left, right);
    }

    // The helper method for merging two sorted lists.
    private ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode visitor = dummy;

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                visitor.next = n1;
                n1 = n1.next;
            } else {
                visitor.next = n2;
                n2 = n2.next;
            }

            // go one step further
            visitor = visitor.next;
        }

        if (n1 == null) {
            visitor.next = n2;
        } else {
            visitor.next = n1;
        }

        return dummy.next;
    }
}

