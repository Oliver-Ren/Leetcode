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
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode curr = head;
        nodeMap.put(null,null);
        
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            nodeMap.put(curr, copy);
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            RandomListNode copy = nodeMap.get(curr);
            copy.next = nodeMap.get(curr.next);
            copy.random = nodeMap.get(curr.random);
            curr = curr.next;
        }
        
        return nodeMap.get(head);
    }
}
