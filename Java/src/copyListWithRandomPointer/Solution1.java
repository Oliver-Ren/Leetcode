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
        RandomListNode dummyHead = new RandomListNode(-1);
        dummyHead.next = head;
        // Round 1: copy the node
        while (head != null) {
            RandomListNode copy = new RandomListNode(head.label);
            copy.next = head.next;
            head.next = copy;
            head = copy.next;
        }
        
        // Round 2: copy the random link
        head = dummyHead.next;
        while (head != null) {
            RandomListNode copy = head.next;
            if (head.random != null) {
                copy.random = head.random.next;
            }
            
            head = copy.next;
        }
        
        // Round 3: restore the next pointer
        head = dummyHead.next;
        RandomListNode copyHead = new RandomListNode(-1);
        RandomListNode copyIter = copyHead;
        while (head != null) {
            RandomListNode copy = head.next;
            copyIter.next = copy;
            head.next = copy.next;
            head = head.next;
            copyIter = copy;
        }
        
        return copyHead.next;
    }
}
