/* This is the advanced solution for reverse
 * LinkedList, it will not only reverse the 
 * whole linked list, but also reverse part
 * of the linked list. */

private ListNode reverseList(ListNode head, int start, int end) {
        ListNode current = head;
        ListNode lastNotRotated = null;
        for (int i = 0; i < start; i++) {
            if (i == start - 1) {
                lastNotRotated = current;
            }
            current = current.next;
        }
        
        ListNode prev = lastNotRotated;
        ListNode startNode = current;
        
        for (int i = start; i < end; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        startNode.next = current;
        
        if (lastNotRotated != null) {
            lastNotRotated.next = prev;
            return head;
        } else {
            return prev;
        }
        
        
    }
