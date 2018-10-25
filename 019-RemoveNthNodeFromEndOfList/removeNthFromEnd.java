/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// one-pass solution
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        // most fast only until there's a gap of n nodes b/w slow and fast
        for (int i = 0; i <= n; i++) 
            fast = fast.next;
        
        // move fast and slow together while maining their gap until fast has reached the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // slow skips the nth node
        slow.next = slow.next.next;
        return dummy.next;      
    }
}