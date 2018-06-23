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
    // Sol 1: recursion
    /*
    private int sum = 0;   // records sum of all keys in descending order
    // Reversed in-order traversal of node.
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += sum;   // update curr value
        sum = root.val;   // then update sum value
        convertBST(root.left);
        return root;
    }
    
    // Sol2: use a stack
    */
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while (!stack.isEmpty() || node != null) {  
            /* Eventually, our stack is empty and node points to the left null child 
            of the tree's minimum value node, so the loop terminates.  */
            
            while (node != null) {   //push all nodes along the path to the rightmost leaf onto the stack. 
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();   // visit the node on the top of the stack
            sum += node.val;
            node.val = sum;
            
            node = node.left;
        }
        return root;
    }
    
}