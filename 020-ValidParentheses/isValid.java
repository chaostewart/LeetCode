class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '(')
                stack.push(')');
            else if (i == '{')
                stack.push('}');
            else if (i == '[')
                stack.push(']');
            // check empty method is named empty() in original class but is named isEmpty() of Collection interface
            else if (stack.isEmpty() || i != stack.pop()) // cases where there are more closing brackets OR brackets don't match
                return false;
        }
        return stack.isEmpty();  // true == all brackets match || false == there are more opening brackets
    }
}
