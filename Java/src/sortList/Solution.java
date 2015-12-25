/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
 * The merge sort like approach.
 * Time complexity: O(nlogn);
 * Space complexity: O(1); 
 * Status: Accepted;
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(middle);
        return mergeTwoLists(l1, l2);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        prev.next = null;
        return slow;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }

        if (a != null) curr.next = a;
        if (b != null) curr.next = b;
        return dummyHead.next;
    }
                
}
