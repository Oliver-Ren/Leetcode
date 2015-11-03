/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

/**
 * The Solution using HashMap.
 * Time complexity: O(n).
 * Space Complexity: O(n).
 * Status: Accepted.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr = head;
        RandomListNode cSentinel = new RandomListNode(-1); // the dummy node.
        RandomListNode cprev = cSentinel; 
        while (curr != null) {
            if (!nodeMap.containsKey(curr)) {
                RandomListNode newNode = new RandomListNode(curr.label);
                nodeMap.put(curr, newNode);
            }
            cprev.next = nodeMap.get(curr);
            if (curr.random != null) {
                if (!nodeMap.containsKey(curr.random)) {
                    RandomListNode newRand = new RandomListNode(curr.random.label);
                    cprev.next.random = newRand;
                    nodeMap.put(curr.random, newRand);
                } else {
                    cprev.next.random = nodeMap.get(curr.random);
                }
            }
            cprev = cprev.next;
            curr = curr.next;
        }
        return cSentinel.next;

    }
}
