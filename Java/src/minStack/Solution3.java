/**
 * The solution where only one stack is required.
 * The idea is that keep a most recent min value, and push it to
 * stack when we meet a smaller or euqal value, so that the old min value
 * is close to the new min value;
 * When pop, if the value at the top is smaller 
 * Time complexity: O(n);
 * Space complexity: O(n);
 * Status: accepted, 432ms.
 */

class MinStack {
    private Stack<Integer> backupStack = new Stack<Integer>();
    private int min = Integer.MAX_VALUE;

    public void push() {
        if (x <= min) {
            backupStack.push(min);
            min = x;
        }
        backupStack.push(x);
    }

    public void pop() {
        if (backupStack.pop() == min) {
            min = backupStack.pop();
        }

    }

    public int top() {
        return backupStack.peek();
    }

    public int getMin() {
        return min;
    }
}

