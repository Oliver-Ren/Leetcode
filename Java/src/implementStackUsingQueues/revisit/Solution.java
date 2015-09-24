/**
 * Revisit of the implement stack using queues.
 * The time complexity is: 
 * The space complexity is:
 * Status:
 */
class MyStack {
    private Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x); 
    }

    // Removes the element on top of the stack.
    public void pop() {
        top();
        queue2.isEmpty() ? queue1.poll() : queue2.poll();
    }

    // Get the top element.
    public int top() {
        int size = queue
    }

    // Return whether the stack is empty.
    public boolean empty() {
        
    }
}
