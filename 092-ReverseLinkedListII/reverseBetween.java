/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy, prev = null;
        
        int count = 0;
        while (count < m) {
            prev = curr;
            curr = curr.next;
            count++;
        }

        ListNode after = curr.next;
        while (count < n) {
            curr.next = after.next;
            after.next = prev.next;
            prev.next = after;
            after = curr.next;
            count++;
        }

        return dummy.next;
    }
}