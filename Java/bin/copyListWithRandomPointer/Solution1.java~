/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

/**
 * First solution.
 * 1. 1st pass: create the node using next and set up the next for the cloned nodes.
 * At the same time, set the next pointer of original to the correspoding clone.
 * 2. 2st pass: using the next pointer and random pointer of original to set up the 
 * random pointer the cloned one.
 * 3. recover the next pointer of the orginal.
 * Time complexity: O(n)
 * Space complexity: O(1)
 * Status: DNF.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
 if (head == null) return null;
        RandomListNode originalCurr = head;
        RandomListNode clonedCurr = new RandomListNode(originalCurr.label);
        RandomListNode clonedHead = clonedCurr;
        originalCurr.next = clonedCurr; 
        while (originalCurr != null) {
            RandomListNode next = originalCurr.next;
            clonedCurr.next = next;
            originalCurr = next;
            if (originalCurr != null) {
                clonedCurr = new RandomListNode(originalCurr.label); 
                originalCurr.next = clonedCurr;
            }
        }

        clonedCurr = clonedHead;
        originalCurr = head;

        while (originalCurr != null) {
            originalCurr.next.random = originalCurr.random.next;
            RandomListNode next = originalCurr.next.next;
            if (next != null) {
                originalCurr.next.next = next.next;
                originalCurr.next = next;
            } else {
                originalCurr.next.next = null;
                originalCurr.next = null;
            }
            originalCurr = originalCurr.next;
        }

        return clonedHead; 
    }
            

}
