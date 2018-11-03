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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTree(postorder, 0, postorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] postorder, int poStart, int poEnd, int inStart, int inEnd, HashMap<Integer,Integer> map) {
        if (inStart > inEnd || poStart > poEnd) return null;
        TreeNode root = new TreeNode(postorder[poEnd]);
        int rootIdx = map.get(root.val);
        int leftSize = rootIdx - inStart;
        
        TreeNode left = buildTree(postorder, poStart, poStart + leftSize - 1, inStart, rootIdx - 1, map);
        TreeNode right = buildTree(postorder, poStart + leftSize, poEnd - 1, rootIdx + 1, inEnd, map);
        root.left = left;
        root.right = right;
        return root;
    }
}