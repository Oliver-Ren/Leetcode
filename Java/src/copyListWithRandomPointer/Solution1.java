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
 * Status: Accepted.
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode dummyHead = new RandomListNode(-1);
        dummyHead.next = head;
        
        // Round one, copy the node
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode next = curr.next;
            RandomListNode copy = new RandomListNode(curr.label);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }
        
        // round two, set the random pointer
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // recover
        curr = head;
        RandomListNode copyHead = head.next;
        while (curr != null && curr.next != null) {
            RandomListNode next = curr.next;
            curr.next = curr.next.next;
            curr = next;
        }
        
        return copyHead;
    }
} 
