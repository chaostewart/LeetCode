/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelHead = new TreeLinkNode(0);
        /* outer while loop moves along the left most node of each level */
        while (root != null) {
            TreeLinkNode levelPtr = levelHead;   // levelPtr traverves each level starting from the 2nd level
            /* inner while loop traverses each level */
            while (root != null) {    
                if (root.left != null) {
                    levelPtr.next = root.left;
                    levelPtr = levelPtr.next;
                }
                if (root.right != null) {
                    levelPtr.next = root.right;
                    levelPtr = levelPtr.next;
                }
                root = root.next;  // root move to its sibling on its right, or hit the level end, NULL
            }
            root = levelHead.next;    // root moves to the front of the most recenlty linked level 
            levelHead.next = null;    // level head pointer is cleared for the next level.
        }
    }
}
