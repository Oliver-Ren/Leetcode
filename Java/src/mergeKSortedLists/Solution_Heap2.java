/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* My second attempt with the method of heap.
 * Time complexity: O(nlogk).
 * Space complexity: O(k);
 * Status: 352ms 
 */

public class Solution {
    // we defined an interface!!!!!!! 
    private Comparator<ListNode> nodeComparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            if (n1 == null) {
                return -1;
            }

            if (n2 == null) {
                return -1;
            }

            return n1.val - n2.val;
        }
    };


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> minPQ 
            = new PriorityQueue<ListNode>(lists.length, nodeComparator); // care!!! how to use interface!!!!! 
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minPQ.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        while (!minPQ.isEmpty()) {
            int size = minPQ.size();
            for (int i = 0; i < size; i++) {
                curr.next = minPQ.poll();
                curr = curr.next;
                if (curr.next != null) {
                    minPQ.offer(curr.next);
                }
            }
        }
        
        return dummy.next;
    }
}


