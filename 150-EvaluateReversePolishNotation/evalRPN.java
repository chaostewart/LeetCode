class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String i : tokens) {
            if (i.equals("+"))
                s.add(s.pop() + s.pop());
            else if (i.equals("-"))
                s.add(- s.pop() + s.pop());
            else if (i.equals("*")) 
                s.add(s.pop() * s.pop());
            else if (i.equals("/")) {
                int a = s.pop();
                int b = s.pop();
                s.add(b / a);
            }
            else 
                s.add(Integer.parseInt(i));
        }
        return s.pop();
    }
}