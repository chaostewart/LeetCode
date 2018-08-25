/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);    
    }
    
    // DFS clone the graph by calling dsf() recursively
    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if (node == null)   // if it's a null node/neighbor
            return null;
        
        if (map.containsKey(node.label)) 
            return map.get(node.label);      // if already made a copy, return/add this copy to upper level's neighbor

        // make a copy of this node
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        // make a copy of all of this node's neighbors 
        for (UndirectedGraphNode nb: node.neighbors) 
            clone.neighbors.add(dfs(nb, map));
        
        return clone;
    }
}