/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
The time complexity for the problem should be O(n), as we visit each node in the tree. 
A string concatenation is too costly. When using StringBuilder, We can keep track of the length of the StringBuilder before we append anything to it before recursion and afterwards set the length back. 
*/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        backtrack(res, root, new StringBuilder());
        return res;
    }
    
    private void backtrack(List<String> res, TreeNode node, StringBuilder sb) {
        if(node == null)
            return;
        int len = sb.length();
        sb.append(node.val);
        if(node.left == null && node.right == null)
            res.add(sb.toString());
        else {
            sb.append("->");
            backtrack(res, node.left, sb);
            backtrack(res, node.right, sb);
        }
        sb.setLength(len);
    }
}