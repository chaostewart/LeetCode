class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();  // stores indices of input array
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            // while there are indices on stack AND current T is higher than the top one on stack
            // indices on stack are in decreasing order from bottom to top
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();  // pop up previous indices of lower T
                res[idx] = i - idx;
            }
            stack.push(i);   // push the current T onto stack
        }
        return res;
    }
}