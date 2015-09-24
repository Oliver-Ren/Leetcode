/**
 * My second attempt for the problem.
 * 
 * Time complexity: O(n);
 * Space complexity: O(n);
 * Status: accepted, 408ms.
 */

class MinStack {
    private Stack<Integer> backupStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        backupStack.push(x);    
        if (minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int top = backupStack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return backupStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

