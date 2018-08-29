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
    /*
    // sol1: generic DFS the tree, also applied for non BST
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }
    
    private boolean dfs(TreeNode root, Set<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
    */

    // First store BST nodes' values in a sorted array using inorder traversal. 
    // Then, use two pointers, from the start and end of the array, respectively, 
    // moving toward each other to find if there is a sum k.
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for (int left = 0, right = nums.size() - 1; left < right;) {
            if (nums.get(left) + nums.get(right) == k)
                return true;
            if (nums.get(left) + nums.get(right) < k)
                left++;
            else 
                right--;
        }
        return false;
    }
    
    public void inorder(TreeNode root, List<Integer> nums){
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}