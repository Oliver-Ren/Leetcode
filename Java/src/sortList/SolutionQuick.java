/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
 * The Solution based on the quick sort.
 * Time complexity: O(nlogn);
 * Space complexity: O(1);
 * Status:
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = partition(head, end);
        ListNode sort(head);
        
        
    }

    private void sortList(ListNode start, ListNode end) {
        if (start == end || start.next == end) return start;
        ListNode middle = partition(start, end);
        sort(start, middle);
        sort(middle.next, end);


    private ListNode partition(ListNode head, ListNode end) {
        if (head == null) return head;
        int val = head.val;
        ListNode dummyLeft = new ListNode(-1);
        ListNode left = dummyLeft;
        ListNode dummyRight = new ListNode(-1);
        ListNode right = dummyRight;

        while (head != end) {
            if (head.val < val) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        left.next = dummyRight.next;
        return dummyRight.next;
    }


