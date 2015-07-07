class MyStack {
    Queue<Integer> leftQueue = new LinkedList<Integer>();
    Queue<Integer> rightQueue = new LinkedList<Integer>();
    int top = 0;
    // Push element x onto stack.
    public void push(int x) {
        if (rightQueue.isEmpty()) {
            leftQueue.add(x);
        } else {
            rightQueue.add(x);
        }
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (leftQueue.size() == 1) {
            leftQueue.poll();
        } else if (rightQueue.size() == 1) {
            rightQueue.poll();
        } else if (!leftQueue.isEmpty()) { 
            while (leftQueue.size() > 1) {
                if (leftQueue.size() == 2) {
                    top = leftQueue.peek();
                }
                rightQueue.add(leftQueue.poll());
            }

            leftQueue.poll();
        } else {
            while (rightQueue.size() > 1) {
                if (rightQueue.size() == 2) {
                    top = rightQueue.peek();
                }
                leftQueue.add(rightQueue.poll());
            }

            rightQueue.poll();
        }
        
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return leftQueue.isEmpty() && rightQueue.isEmpty();
        
    }
}
