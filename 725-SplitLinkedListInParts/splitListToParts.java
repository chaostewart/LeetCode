/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];    
        int len = 0;
        ListNode curr = root;   
        while(curr != null) {          // have to iterate the list to get the length
            len++;
            curr = curr.next;
        }
        int n = len / k, r = len %k;  // n = minimum part size; r = extra r nodes spread to the first r parts;      
        ListNode prev = null;
        curr = root;
        for (int i = 0; i < k && curr != null; i++, r--) {    
            ans[i] = curr;
            for(int j = 0; j < n + (r > 0 ? 1 : 0); j++) { // add n+1 or n nodes to each part, r > 0 means still remainder left
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
        }
        return ans;
    }
}