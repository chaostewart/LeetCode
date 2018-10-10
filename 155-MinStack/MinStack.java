// sol 1: faster. top element on stack is an array store the top value and min value so far
class MinStack {
    private Stack<int[]> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty())
            stack.push(new int[] {x, x});
        else {
            int[] top = stack.peek();
            stack.push(new int[] {x, Math.min(x, top[1])});
        }      
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        int[] top = stack.peek();
        return top[0];
    }
    
    public int getMin() {
        int[] top = stack.peek();
        return top[1];
    }
}
// sol 2: create a class node that stores the current node value and min value so far, without using stack

class MinStack {
    
    private class Node {
        int val;
        int min;
        Node next;
        
        private Node (int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    /** initialize your data structure here. */
    private Node top;
    
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (top == null)
            top = new Node(x, x, null);
        else
            top = new Node(x, Math.min(x, top.min), top);
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;
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
