import java.util.Stack;
/** Soluion using one stack in the class. 
  * Time complexity: O(n) for.
  * Space complexity: O(n).
  * Status: Accpeted.
  */

class MyQueue {
    private Stack<Integer> outStack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        int size = outStack.size();
        int[] reorderBuffer = new int[size];
        for (int i = 0; i < size; i++) {
            reorderBuffer[i] = outStack.pop();
        }

        outStack.push(x); 

        for (int i = size - 1; i >= 0; i--) {
            outStack.push(reorderBuffer[i]);
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
       return outStack.empty(); 
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());

    }

}
