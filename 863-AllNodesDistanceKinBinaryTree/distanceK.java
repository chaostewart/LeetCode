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
We first do a depth first search where we map every node with its parent and children 
-- build undirected map
After, we do a breadth first search to find all nodes a distance K from the target.
*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        buildMap(root, null, map);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            if (K == 0) {
                for (int i = 0; i < levelSize; i++) 
                    res.add(q.poll().val);
                return res;
            }
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {   // get current node's parent and children
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }  
                }
            }
            K--;
        }
        return res;
    }

    private void buildMap(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> map) {
        if (node == null) return;   // does not add leaf nodes' children
        map.put(node, new ArrayList<TreeNode>());
        if (parent != null) {    // does not map null with root node
            map.get(node).add(parent); 
            map.get(parent).add(node) ;
        }
        buildMap(node.left, node, map);
        buildMap(node.right, node, map);
        
    } 
}