// Times: O(n1 + n2), space: O(n2)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();       // map<nums2[i], 1st num larger than nums2[i]
        Stack<Integer> stack = new Stack();          // numbers pushed onto stack are in descending order
        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i)
                map.put(stack.pop(), i);
            stack.push(i);
        }
        // numbers left on stack are numbers that don't have larger number after them
        for (int i = 0; i < nums1.length; i++) 
            res[i] = map.getOrDefault(nums1[i], -1);
        
        return res;
    }
}