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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<>();
        if (root == null)
            return res;
    
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();     // map<colNum, listOfNodes>
        Queue<TreeNode> queue = new LinkedList<>();     // queue of nodes traversed in preorder (BFS)
        Queue<Integer> cols = new LinkedList<>();       // corresponding colNumb of nodes
        
        queue.add(root);
        cols.add(0);
        
        int colMin = 0, colMax = 0;      // records the boundaries of colNum
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.poll();
            colMin = Math.min(colMin, col);
            colMax = Math.max(colMax, col);
            
            if (!map.containsKey(col))
                map.put(col, new ArrayList<Integer>());
            map.get(col).add(node.val);     // add current node's val to result
            
            if (node.left != null) {         // add left child to queue
                queue.add(node.left);
                cols.add(col - 1);
            }
            
            if (node.right != null) {       // add right child to queue
                queue.add(node.right);
                cols.add(col + 1);
            }
        }
        for (int i = colMin; i <= colMax; i++)
            res.add(map.get(i));
        return res;
    }
}