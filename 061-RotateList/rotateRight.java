/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;       // traverse the list once to obtain length
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        curr.next = head;  // connect tail with head to form a loop
        
        int shifts = len - k % len;
        while (shifts-- > 0)
            curr = curr.next;
    
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}