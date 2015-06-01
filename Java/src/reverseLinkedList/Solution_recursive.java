/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
		/* reached the end of the linked list. */
		if (head.next == null) {
			return head;
		}

		ListNode reversedHead = reverseList(head.next);

		head.next.next = head;

		/* to deal with the corner case of the left move node. */
		head.next = null;

		return reversedHead;
	
	
	}



