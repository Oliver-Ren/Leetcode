/**
 * Revisit of the implement stack using queues.
 * This approach only uses one queue.
 * The time complexity is: O(n) for push, O(1) otherwise. 
 * The space complexity is: O(n)
 * Status: accepted, 31ms
 */
class MyStack {
    private Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        int size = queue.size();
        queue.offer(x); 
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty(); 
    }
}
