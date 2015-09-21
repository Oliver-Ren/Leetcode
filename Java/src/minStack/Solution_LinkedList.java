/**
 * The solution which uses linked list directly.
 * status: accepted, 552ms.
 */

class MinStack {
    private class ListNode {
        private int value;
        private int min;
        private ListNode next;
        
        private ListNode(int x, int m) {
            value = x;
            min = m;
            next = null;
        }
    }

    // initiallize top with a dummy node.
    private ListNode top = new ListNode(0, Integer.MAX_VALUE); 
    
    public void push(int x) {
        ListNode newValue = new ListNode(x, Math.min(x, top.min));
        newValue.next = top;
        top = newValue;
    }

    public void pop() {
        ListNode next = top.next;
        top.next = null;
        top = next;    
    }

    public int top() {
        return top.value;
    }

    public int getMin() {
        return top.min;
    }
}

