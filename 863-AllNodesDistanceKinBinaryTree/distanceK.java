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
Instead of building a whole undirected graph, only store reversed edges in map
this speeds up from 16% to 65%
*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildBackEdges(root, null, map);
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int count = 0;
        while (!queue.isEmpty()) {         
            if (count == K) {
                while(!queue.isEmpty())
                    ans.add(queue.poll().val);
                return ans;
            }
            
            int size = queue.size();
            while(size-->0) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.add(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.add(curr.right);
                    visited.add(curr.right);
                }
                if (map.get(curr) != null && !visited.contains(map.get(curr))) {
                    queue.add(map.get(curr));
                    visited.add(map.get(curr));
                }               
            }
            count++;                     
        }
        return ans;
    }
    
    private void buildBackEdges(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) return;
        if (parent != null)
            map.put(node, parent);
        buildBackEdges(node.left, node, map);
        buildBackEdges(node.right, node, map);
    }
}

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
