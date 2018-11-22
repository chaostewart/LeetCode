/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// newer version: preEnd is not necessary in the helpe function
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return build(preorder, 0, 0, inorder.length - 1, inMap);
    }
    
    private TreeNode build(int[] preorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd) 
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIn = inMap.get(root.val);      // find the index of root in inorder array
        int leftNum = rootIn - inStart;        // leftNum is the number of nodes in the left subtree of root
        // build(preorder, root of left subtree, inorder, leftmost node in tree, rightmost node in left subtree, map)
        root.left = build(preorder, preStart + 1, inStart, rootIn - 1, inMap);
        // build(preorder, root of right subtree, inorder, leftmost node in right subtree, rightmost node in tree, map)
        root.right = build(preorder, preStart + 1 + leftNum, rootIn + 1, inEnd, inMap);
        return root;
    }
}


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
