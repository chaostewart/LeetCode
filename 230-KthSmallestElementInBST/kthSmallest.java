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
    // sol1: binary search, get subtree size, determine where answer resides
    public int kthSmallest(TreeNode root, int k) {       
        int left = countNodes(root.left);
        if ( left >= k)             // left subtree has >= k nodes, ans is in the left subtree
            return kthSmallest(root.left, k);
        else if (left == k - 1)     // ans is the current root node
            return root.val;
        else                        // ans is in the right subtree
            return kthSmallest(root.right, k - left - 1);
    }
    
    public int countNodes(TreeNode n) {
        if (n == null) return 0;       
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
    
    /*
    // sol 2: in-order traverse the BST, same run time as above
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums, k);
        return nums.get(k-1);
    }
    
    private void inorder(TreeNode root, List<Integer> nums, int k) {
        if (root == null || nums.size() == k) return;
        inorder(root.left, nums, k);
        nums.add(root.val);
        inorder(root.right, nums, k);
    }
    */
}
