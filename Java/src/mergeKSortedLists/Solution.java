/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* My first attempt for the problem.
 * The thoughts are using a min heap to
 * keep the minium among k lists. 
 * poll the minimum, and offer it's next
 * Time complexity: O(nlogk).
 * Space complexity: O(k);
 * Status: accepted, 388ms.
 */

public class Solution {
    // We should create a comparator for the ListNode class
    private class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minPQ = new PriorityQueue<ListNode>(lists.length, new NodeComparator());
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        for (int i = 0; i < lists.length; i++) {
            // Be very careful not to add null into the queue.
            if (lists[i] != null) {
                minPQ.offer(lists[i]);
            }
        }

        while (!minPQ.isEmpty()) {
            curr.next = minPQ.poll();
            curr = curr.next;
            if (curr.next != null) {
                minPQ.offer(curr.next);
            }
        }

        return dummy.next;
            
    }
}

