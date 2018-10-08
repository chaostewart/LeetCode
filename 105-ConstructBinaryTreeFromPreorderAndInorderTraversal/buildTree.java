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
    Node at preorder[0] is the root node.
    We can find this root node in the inorder array using a hashmap
    In the inorder array, all nodes one the left side of root node belong to root's left subtree
    Recursively construct a tree using each subarray
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdx = map.get(root.val);
        int leftSize = rootIdx - inStart;
        
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inStart, rootIdx - 1, map);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, rootIdx + 1, inEnd, map);
        return root;
    }
}