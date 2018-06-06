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
        ListNode prehead = new ListNode(-1);  // Unlike Q2, there' no need to make a copy of input parameters...why?
        ListNode p = prehead;
        while(l1 != null && l2 != null) {  // case where both list have not reached the end, comparison is needed
            if (l1.val < l2.val) {
                p.next = l1;     // move pointers along two lists, no need to create no listnodes
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null? l2 : l1;    // whichever list has not reached the end will be appended to the result
        return prehead.next;
    }
}