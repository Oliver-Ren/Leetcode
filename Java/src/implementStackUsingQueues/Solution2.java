class MyStack {
    Queue<Integer> backupQueue = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
       backupQueue.offer(x);
       for (int i = 0; i < backupQueue.size() - 1; i++) {
           backupQueue.offer(backupQueue.poll());
       }
    }

    // Removes the element on top of the stack.
    public void pop() {
       backupQueue.poll();
    }

    // Get the top element.
    public int top() {
       return backupQueue.peek(); 
    }

    // Return whether the stack is empty.
    public boolean empty() {
       return backupQueue.isEmpty(); 
    }
}
