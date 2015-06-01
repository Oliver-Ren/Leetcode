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
		/* for the condition of no nodes or signle nodes*/
		if (head == null || head.next == null) {
			return head;
		}	

		ListNode prev = null;
		ListNode next = head.next;

		while (head.next != null) {
			head.next = prev;
			prev = head;
			head = next;
			next = head.next;
		}

		head.next = prev;
		return head;
		
	
	}



