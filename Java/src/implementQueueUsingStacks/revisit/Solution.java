/** Soluion using two stacks. 
  * Time complexity: Amortized constant for each operation.
  * Space complexity: O(n).
  * Status: Accpeted.
  */

class MyQueue {
    private Stack<Integer> inStack = new Stack<Integer>();
    private Stack<Integer> outStack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x); 
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
       return inStack.empty() && outStack.empty(); 
    }
}
