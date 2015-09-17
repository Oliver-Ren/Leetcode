import java.util.*;
/**
 * My second attempt for LRU cache.
 * 
 * Space complexity: O(n).
 * Time complexity on insert: O(1).
 * Time complexity on find: O(1).
 * Status: accepted, 504ms.
 */

public class LRUCache_2 {
    private class ListNode {
        private ListNode prev;
        private ListNode next;
        private int key;
        private int value;

        private ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

    }

    private HashMap<Integer, ListNode> nodeTable
        = new HashMap<Integer, ListNode>();

    private int capacity;

    ListNode dummyHead = new ListNode(-1, -1);
    ListNode dummyTail = new ListNode(-1, -1);

    public LRUCache_2(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.prev= dummyHead;
    }

    public int get(int key) {
        if (!nodeTable.containsKey(key)) {
            return -1;
        }

        ListNode curr = nodeTable.get(key);
        
        //delete the current node.
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;

        // move the current node to the front.
        moveToFront(curr); 

        return curr.value;
    } 

    public void set(int key, int value) {
        // if already in cache
        if (get(key) >= 0) {
            nodeTable.get(key).value = value; 
            return;
        }

        // if not in cache

        ListNode newNode = new ListNode(key, value);
        nodeTable.put(key, newNode);
        moveToFront(newNode);

        // check if the cache is full;
        if (nodeTable.size() > capacity) {
            // clear node table
            nodeTable.remove(dummyTail.prev.key);

            // delete from linked list
            dummyTail.prev.prev.next = dummyTail;
            dummyTail.prev = dummyTail.prev.prev;
            
        }
    }

    private void moveToFront(ListNode node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next = node;
        node.next.prev = node;
    }
            




    public static void main(String[] args) {
        LRUCache_2 cache = new LRUCache_2(3);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
    }
}
            

            
            
