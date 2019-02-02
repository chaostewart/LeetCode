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
        ListNode curr = head, prev = dummy;
        int count = 1;
        while (count < m) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        // during reversing, pointer prev and curr are fixed, pointing to node m-1 and node m, respectively, all the time
        // whereas the pointer newPrev moves along the list
        // the order of new list looks like 
        // -> prev(old node m-1)->newPrev(old node n)->...->(old node m+2)->(old node m+1)->curr(old node m)->(node n+1)->...
        ListNode newPrev = curr.next;
        while(count < n) {
            curr.next = newPrev.next;
            newPrev.next = prev.next;
            prev.next = newPrev;
            newPrev = curr.next;
            count++;
        }
        return dummy.next;
    }
}
