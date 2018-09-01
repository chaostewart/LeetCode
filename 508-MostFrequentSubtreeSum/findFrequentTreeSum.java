/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private int max_freq;   // records the max frequency of a sum
    
    public int[] findFrequentTreeSum(TreeNode root) {
        max_freq = 0;
        Map<Integer, Integer> map = new HashMap<>();    // map<subtree sum value, frequency>
        dfsGetSum(root, map);
        List<Integer> ans = new ArrayList<>();     // store sums with max frequency in a list
        
        for (int val: map.keySet())
            if (map.get(val) == max_freq)
                ans.add(val);
        
        int[] res = new int[ans.size()];   // convert list to array
        for (int i = 0; i < ans.size(); i++) 
            res[i] = ans.get(i);
        
        return res;
    }
    
    private int dfsGetSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;   // null returns 0
        int sum = dfsGetSum(root.left, map) + dfsGetSum(root.right, map) + root.val;    // left subtree + right subtree + root val
        map.put(sum, map.getOrDefault(sum, 0) + 1);    
        max_freq = Math.max(max_freq, map.get(sum));
        return sum;
    }
}
