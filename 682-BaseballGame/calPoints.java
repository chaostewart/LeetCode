class Solution {
    public int calPoints(String[] ops) {
        // Use a stack because we at most need to trace back the last two valid scores
        // push and pop are easy
        Stack<Integer> stack = new Stack<>();
        for (String op: ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int sum = 0;
        // use this for loop to iterate the stack
        for (int score: stack) 
            sum += score;
        return sum;
    }
}