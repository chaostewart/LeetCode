/*
Goal: use two colors to color the graph and see if there are any adjacent nodes having the same color.
Initialize a color[] array for each node. Here are three states for colors[] array:
-1: Blue.
0: Hasn't been colored.
1: Red.
For each node, 
if it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
if it has been colored, check if it's correctly colored.
*/


class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++)  //This graph might be a disconnected graph. So check each unvisited node and color each subgraph.
            // if colors[i] != 0, node i has been visited, the second if condition won't be evaluated
            if (colors[i] == 0 && !validColor(graph, colors, 1, i))
                return false;
        return true;
    }
    
    // DFS
    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0)  // if node has been colored, check if it's consistent here
            return colors[node] == color;
        colors[node] = color;
        for (int adjacent : graph[node])   // use the opposite color to color all node's neighbors
            if (!validColor(graph, colors, -color, adjacent))
                return false;
        return true;
    }
}