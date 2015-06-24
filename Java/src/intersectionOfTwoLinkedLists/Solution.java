/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode ptrA = headA;
	   ListNode ptrB = headB;
	   int lengthA = 0;
	   int lengthB = 0;

	   while (true) {
		   if (ptrA == null && ptrB == null) {
			   break;
		   }

		   if (ptrA != null) {
				ptrA = ptrA.next;
				lengthA++;
		   }

		   if (ptrB != null) {
			   ptrB = ptrB.next;
			   lengthB++;
		   }

	   }

	   int longerLen;
	   int shorterLen;
	   ListNode longerPtr;
	   ListNode shorterPtr;

	   if (lengthA > lengthB) {
		   longerLen = lengthA;
		   longerPtr = headA;
		   shorterLen = lengthB;
		   shorterPtr = headB;
	   } else {
		   longerLen = lengthB;
		   longerPtr = headB;
		   shorterLen = lengthA;
		   shorterPtr = headA;
	   }

	   while (longerLen > shorterLen) {
		   longerPtr = longerPtr.next;
		   longerLen--;
	   }

	   while (true) {
		   if (longerPtr == shorterPtr) {
			   return shorterPtr;
		   }

		   longerPtr = longerPtr.next;
		   shorterPtr = shorterPtr.next;
	   }

	}
}



