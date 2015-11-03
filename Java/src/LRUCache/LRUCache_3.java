import java.util.*;

public class LRUCache_3 {
    private static class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;
        public ListNode(int key, int val) {
            this.key = key;
            value = val;
            next = null;
            prev = null;
        }
    }
    
    private ListNode leftSentinel;
    private ListNode rightSentinel;
    private int capacity;
    private int size;
    private Map<Integer, ListNode> nodeMap;
    
    public LRUCache_3(int capacity) {
        this.capacity = capacity;
        size = 0;
        leftSentinel = new ListNode(-1, -1);
        rightSentinel = new ListNode(-1, -1);
        leftSentinel.next = rightSentinel;
        rightSentinel.prev = leftSentinel;
        nodeMap = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        ListNode target = nodeMap.get(key);
        deleteFromList(target);
        moveToHead(target);
        return target.value;
    }
    
    public void set(int key, int value) {
        if (nodeMap.containsKey(key)) {
            nodeMap.get(key).value = value;
            get(key);
        } else {
            ListNode newNode = new ListNode(key, value);
            nodeMap.put(key, newNode);
            moveToHead(newNode);
            size++;
            
            // if is full
            if (size > capacity) {
                ListNode last = rightSentinel.prev;
                deleteFromList(last);
                nodeMap.remove(last.key);
                size--;
            }
        }
    }
    
    private void deleteFromList(ListNode target) {
        target.prev.next = target.next;
        target.next.prev = target.prev;
        // prevent loitering objects;
        target.prev = null;
        target.next = null;
    }
    
    private void moveToHead(ListNode target) {
        target.next = leftSentinel.next;
        target.prev = leftSentinel;
        leftSentinel.next.prev = target;
        leftSentinel.next = target;
    }

    public static void main(String[] args) {
        LRUCache_3 cache = new LRUCache_3(1);
        cache.set(2,1);
        cache.get(2);
        cache.set(3,2);
        cache.get(2);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
    }
}
            

            
            
