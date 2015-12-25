/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
 * Idea: 1. find the middle of the list
 *       2. reverse the list from middle to end.
 *       3. merge the tow parts of the list.
 * time complexity: O(n);
 * space complexity: O(1);
 * Status: Accepted. 
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode middle = findMiddle(head);
        Listnode head2 = middle.next;
        middle.next = null;
        head2 = reverse(head2);
        merge(head, head2);
    }

    private ListNode findMiddle(ListNode head) {
        // precondtion: head is not null
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    private void merge(ListNode a, ListNode b) {
        ListNode dummyHead = new ListNode(-1);
        boolean turn = true;
        ListNode curr = dummyHead;
        while (a != null && b != null) {
            if (turn) {
                curr.next = a;
                a = a.next;
                turn = false;
            } else {
                curr.next = b;
                b = b.next;
                turn = true;
            }
            curr = curr.next;
        }

        if (a == null) curr.next = b;
        else curr.next = a;
    }
}


        

            


