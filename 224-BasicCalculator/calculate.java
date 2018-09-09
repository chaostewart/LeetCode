class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = 10 * num + (int)(c - '0');
            else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            }
            else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            }
            else if (c == '(') {
                stack.push(res);     //push the result before ()
                stack.push(sign);    //push the sign after result before ()
                res = 0;             // reset result and sign for evaluating what's inside the following ()
                sign = 1;
            }
            else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();    //stack.pop() is the sign before the ()
                res += stack.pop();    //stack.pop() now is the result calculated before the ()
            }
        }
        res += sign * num;
        return res;
    }
}