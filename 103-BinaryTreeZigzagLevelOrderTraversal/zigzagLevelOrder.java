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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {       
            int levelSize = q.size();
            List<Integer> levelList = new ArrayList<>(levelSize);
            while (levelSize > 0) {
                TreeNode node = q.poll();
                levelList.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                levelSize--;
            }
            if (res.size() % 2 == 1)
                Collections.reverse(levelList);
            res.add(levelList);        
        }
        return res;
    }
    
 // Or use TWO STACKS withort reversing the sublist
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
   List<List<Integer>> ans = new ArrayList<>();
   if(root == null) return ans;
   Stack<TreeNode> s1 = new Stack<>();
   Stack<TreeNode> s2 = new Stack<>();
   s1.push(root);
   TreeNode curr = null;
   while(!s1.isEmpty() || !s2.isEmpty()) {
        List<Integer> sublist = new ArrayList<>();
        while(!s1.isEmpty()) {
            curr = s1.pop();
            sublist.add(curr.val);
            if(curr.left != null)
                s2.push(curr.left);
            if(curr.right != null) 
                s2.push(curr.right);
        }
        ans.add(sublist);
        sublist = new ArrayList<>();
        while(!s2.isEmpty()) {
            curr = s2.pop();
            sublist.add(curr.val);
            if(curr.right != null)
                s1.push(curr.right);
            if(curr.left != null)
                s1.push(curr.left);
        }
        if(!sublist.isEmpty()) 
            ans.add(sublist);
   }
   return ans;
}
    /* old version // with helper funtion and recursion
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        DFStraverse(root, res, 0);
        return res;
    }
    
    // recursive DFS traversal on the tree from left child to right child of each node
    private void DFStraverse(TreeNode curr, List<List<Integer>> res, int level) {
        if (curr == null)   // leaf case
            return;
        
        if (res.size() <= level) {     // create a inner list for each level of nodes
            List<Integer> newLevel = new LinkedList();
            res.add(newLevel);
        }
        
        List<Integer> currLevel = res.get(level);   // get the current level's inner list from outer list
        if (level % 2 == 0)                         // for even-number levels, traversal is from left to right
            currLevel.add(curr.val);                // so add new node value to the end of inner list
        else                                        // for odd-number levels, traversal is from right to left
            currLevel.add(0, curr.val);             // so add new node value to the front (index = 0) of inner list
        
        DFStraverse(curr.left, res, level + 1);     // traverse from left to right
        DFStraverse(curr.right, res, level + 1);
        */
    }
}
