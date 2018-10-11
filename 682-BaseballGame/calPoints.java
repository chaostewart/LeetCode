class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if (s.equals("+")) {
                int prev = stack.pop();
                int curr = prev + stack.peek();
                stack.push(prev);
                stack.push(curr);
            } else if (s.equals("D"))
                stack.push(2*stack.peek());
            else if (s.equals("C"))
                stack.pop();
            else 
                stack.push(Integer.parseInt(s));
        }
        int ans = 0;
        while (!stack.isEmpty()) 
            ans += stack.pop();
        return ans;
    }
}
