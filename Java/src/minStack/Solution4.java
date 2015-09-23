/**
 * The solution where only one stack is required.
 * The idea is to store the difference between x and min.
 * When pop, if the value at the top is smaller 
 * Time complexity: O(n);
 * Space complexity: O(n);
 * Status: accepted, 628ms.
 */

class MinStack {
    private Stack<Long> backupStack = new Stack<Long>();
    private long min = Integer.MAX_VALUE;

    public void push() {
        if (backupStack.empty()) {
            backupStack.push(0L);
            min = x;
        } eise {
            backupStack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        long diff = backupStack.pop(); 
        if (diff < 0) {
            min = min - diff;
        }
    }

    public int top() {
        if (backupStack.peek() < 0) {
            return (int)min;
        } else {
            return (int) (backupStack.peek() + min);
        }
    }

    public int getMin() {
        return (int) min;
    }
}

