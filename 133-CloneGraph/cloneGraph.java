/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // BFS solution
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        // map a label to a clone node
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        // put the first cloned node in map before while loop!
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(copy.label, copy);
        // queue stores original node whose neighbors haven't been deep cloned yet
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();     
            for (UndirectedGraphNode neighbor: curr.neighbors) {
                // if this neighbor is new, make a copy and put in map, also add it to queue for later inspection
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));  
                    queue.add(neighbor);
                } 
                // linked cloned neighbors to cloned node
                map.get(curr.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return copy;   
    }
    /*
    // DFS solution
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
    */
}
