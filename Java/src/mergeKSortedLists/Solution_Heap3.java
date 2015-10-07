/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static final Comparator<ListNode> BY_VALUE = new NodeComparator();
    private static class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode n1, ListNode n2) {
            // precondition: n1 and n2 are not null
            if (n1.val < n2.val) {
                return -1;
            } else if (n1.val > n2.val) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        // dealing with precondition that lists is not null
        // and the length of list is greater than zero.
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, BY_VALUE);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
                lists[i] = lists[i].next;
            } 
        }
        
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        
        return head.next;
        
    }
}
