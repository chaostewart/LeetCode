// Stack is convenient when there are nested brackets
class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                k = k * 10 + c - '0';
            else if ( c == '[') {
                intStack.push(k);
                strStack.push(sb);   // after initialization, sb is empty char array, like empty string ""
                sb = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder curr = sb;
                sb = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) 
                    sb.append(curr);
            } else 
                sb.append(c);
        }
        return sb.toString();
    }
}