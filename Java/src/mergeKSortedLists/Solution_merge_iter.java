/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
 * The iterative divide and conquer
 * solution.
 * Status: Accepted, 4ms.
 */
public class Solution_merge_iter {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int N = lists.length;
        for (int sz = 1; sz < N; sz += sz) {
            for (int i = 0; i < N; i += sz + sz) {
                if (i + sz < N) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + sz]);
                }
            }
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 == null) curr.next = l2;
        if (l2 == null) curr.next = l1;
        return head.next;
    }

    public static void main(String[] args) {
        Solution_merge_iter s = new Solution_merge_iter();
        ListNode[] lists = new ListNode[3];
        lists[0] = null;
        lists[1] = new ListNode(1);
        lists[2] = new ListNode(3);
        
        ListNode head = s.mergeKLists(lists);
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
    }

}
