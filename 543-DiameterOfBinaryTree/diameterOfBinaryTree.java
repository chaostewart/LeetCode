/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// clearer and faster
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        getDepthOfTree(root, res);
        return res[0];
    }
    
    private int getDepthOfTree(TreeNode root, int[] res) {
        if (root == null) return 0;
        int l = getDepthOfTree(root.left, res);
        int r = getDepthOfTree(root.right, res);
        res[0] = Math.max(res[0], l + r);
        return 1 + Math.max(l, r);
    }
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return DFS(root)[0];
    }
    // int[2] = [best, height]
    private int[] DFS(TreeNode node) {
        if (node == null) return new int[] {0, 0};
        int[] left = DFS(node.left);
        int[] right = DFS(node.right);
        
        int best = Math.max(Math.max(left[0], right[0]), left[1] + right[1]);
        int height = 1 + Math.max(left[1], right[1]);
        return new int[] {best, height};
    }
}

// slow but clearer solution
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int curr = maxDepth(root.left) + maxDepth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(curr, Math.max(left, right));
    }
     public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     } 
}
