/** Soluion
  * using two stacks
  * Status: Accpeted.
  */

class MyQueue {
    private Stack<Integer> primStack = new Stack<Integer>();
    private Stack<Integer> backupStack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        while (!primStack.empty()) {
            backupStack.push(primStack.pop());
        }

        primStack.push(x);

        while (!backupStack.empty()) {
            primStack.push(backupStack.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        primStack.pop();
        
    }

    // Get the front element.
    public int peek() {
        return primStack.peek();
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return primStack.empty();
        
    }
}
