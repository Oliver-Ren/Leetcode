/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* The second method:
 * make use of merge 2 sorted lists,
 * and then merge in multiple rounds.
 * kind like the two-way external 
 * merge sort.
 * The merge is implemented in-place.
 * Time complexity: O(nlogk) where n is 
 * the length of the longest list.
 * Space complexity: O(k);
 * Status: DNF.
 */

public class Solution_merge2 {

    public ListNode mergeKLists(ListNode[] lists) {
        // Dealing with corner case  inputs
        if (lists == null || lists.length == 0) {
            return null;
        }

        int len = lists.length;

        // control rounds
        while (len > 1) {
            int groupPos = 0; // position of current group, a group is two neighbor lists. 
            while (groupPos < len) { 
                if (groupPos == len - 1) {
                    lists[groupPos >> 1] = lists[groupPos];
                } else {
                    lists[groupPos >> 1] 
                        = mergeTwoLists(lists[groupPos], lists[groupPos + 1]);
                }
                
                groupPos += 2;
            }

            len = groupPos >> 1;
        }

        return lists[0];
    }

    // The helper method for merging two sorted lists.
    private ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        } else if (n2 == null) {
            return n1;
        }

        ListNode head = n1.val > n2.val ? n2 : n1;
        mergeTwoListsHelper(n1, n2);

        return head; 
    }

    // the helper method for recursively merging the lists.
    private void mergeTwoListsHelper(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) {
            return;
        }

        if (n1.val > n2.val) {
            ListNode n2Next = n2.next; 
            n2.next = n1;
            mergeTwoListsHelper(n1, n2Next);
        } else {
            ListNode n1Next = n1.next;
            n1.next = n2;
            mergeTwoListsHelper(n1Next, n2);
        }
    }
}

            




