import java.util.Stack;
/** Soluion using one stack with recursive calls. 
  * Time complexity: O(n) for push, O(1) for other operations.
  * Space complexity: O(n).
  * Status: Accpeted.
  */

class MyQueue2 {
    private Stack<Integer> outStack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        if (outStack.empty()) {
            outStack.push(x);
        } else {
            int temp = outStack.pop();
            push(x);
            outStack.push(temp);
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
        MyQueue2 q = new MyQueue2();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());

    }

}
