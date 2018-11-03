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
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (K == 0) {
                while (!queue.isEmpty())
                    res.add(queue.poll().val);
                return res;
            }
            while (levelSize-- > 0) {
                TreeNode curr = queue.poll();
                for (TreeNode nb : graph.get(curr))   // get current node's parent and children
                    if (!visited.contains(nb)) {
                        queue.offer(nb);
                        visited.add(nb);
                    }
            }        
            K--;
        }
        return res;
    }
    
    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;           // does not map null with leaves
        graph.put(node, new ArrayList<>());  // must create list for each node
        if (parent != null) {               // does not map null with root node
            graph.get(parent).add(node);    // parent already exists in map
            graph.get(node).add(parent);
        }
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}
