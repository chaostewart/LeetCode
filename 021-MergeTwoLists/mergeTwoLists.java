/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);  
        ListNode c1 = l1, c2 = l2, p = dummy;
        while(c1 != null && c2 != null) {  // case where both list have not reached the end, comparison is needed
            if (c1.val < c2.val) {
                p.next = c1;     // move pointers along two lists, no need to create no listnodes
                c1 = c1.next;
            } else {
                p.next = c2;
                c2 = c2.next;
            }
            p = p.next;
        }
        p.next = c1 == null? c2 : c1;    // whichever list has not reached the end will be appended to the result
        return dummy.next;
    }
}
