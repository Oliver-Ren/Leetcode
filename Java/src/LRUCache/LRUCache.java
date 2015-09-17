import java.util.*;
/**
 * My first attempt for LRU cache.
 * the intuition is using an min heap
 * to back-up the cache for the keys.
 * Then use the HashMap to map from
 * key to value.
 *
 * It may not be a good thing to firstly think 
 * about using priority queue for two reasons:
 *	1. Design complexity
 *	2. Immutability of Keys in priority queue.
 * ============================================
 *
 * Instead, using a doubly linked-list is a 
 * good choice.
 * using a HashMap to keep the address of each
 * node.
 * 
 * Space complexity: O(n).
 * Time complexity on insert: O(1).
 * Time complexity on find: O(1).
 * Status: accepted, 588ms.
 */

public class LRUCache {
    HashMap<Integer, ListNode> nodeTable = new HashMap<Integer, ListNode>(); 
    private int capacity;

    private class ListNode {
        private ListNode prev;
        private ListNode next;
        int key;
        int value;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    
    private ListNode head = new ListNode(-1, -1);
    private ListNode tail = new ListNode(-1, -1);

    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (!nodeTable.containsKey(key)) {
            return -1;
        }

        ListNode curr = nodeTable.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next = head.next;
        curr.prev = head;
        curr.next.prev = curr;
        head.next = curr;

        return nodeTable.get(key).value;
    }
        
    public void set(int key, int value) {
        // conditions where the key exists,
        // we simply updated the value and 
        // call get(key)

        if (nodeTable.containsKey(key)) {
            nodeTable.get(key).value = value;
            get(key);
        } else {
            ListNode newNode = new ListNode(key, value);
            // add the new node to the first;
            nodeTable.put(key, newNode);
            newNode.prev = head;
            newNode.next = head.next;
            newNode.next.prev = newNode;
            head.next = newNode;


            // deleted the last node if reached capacity.
            if (nodeTable.size() > capacity) {
                nodeTable.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
            }
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
    }
}
            

            
            
