/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Preorder traversal
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    // Preorder traversal the BST recursively
    public void serialize(TreeNode root, StringBuilder sb) {  // an overriding function
        if (root == null) 
            sb.append("null" + ",");      // if reached leaves' left or right children, return null;
        else {
            sb.append(root.val + ",");    // add current root's value, then recurse on its children
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));  
        // convert a string array to a list then enqueue all elements in the list to queue
        return deserialize(queue);
    }
    
    public TreeNode deserialize(Queue<String> queue) {   // an overriding function
        // don't need to check if queue is empty! because null values at the end of queue won't traverse further
        String curr = queue.poll();
        if (curr.equals("null")) return null;  // reached an end, return null nodes
        TreeNode root = new TreeNode(Integer.parseInt(curr));   // convert string to int
        root.left = deserialize(queue);       // recurse on left child then right child
        root.right = deserialize(queue);
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
