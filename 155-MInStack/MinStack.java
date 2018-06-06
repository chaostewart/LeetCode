class MinStack {
    
    /** initialize your data structure here. */

    private Node top;

    public void push(int x) {
        if (top == null) {
            top = new Node(x, x, null);
        } else {
            top = new Node(x, Math.min(x, top.min), top);
        }
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;   // O(1) 
    }
    
    private class Node {
        int val;    // each node in the stack contains its own value 
        int min;   // and the min value from the bottom of the stack up to its level
        Node next;

        private Node (int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
   
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */