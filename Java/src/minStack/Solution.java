/**
 * My first attempt for the problem.
 * 
 * Time complexity: O(n);
 * Space complexity: O(n);
 * Status: DNF.
 */

class MinStack {
    private Stack<Integer> backupStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        backupStack.push(x);    
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(x, minStack.peek()));
        }
    }

    public void pop() {
        minStack.pop();
        backupStack.pop();
    }

    public int top() {
        return backupStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

