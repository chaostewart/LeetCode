/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        /*
        ListNode dummy = new ListNode(0), curr = head, prev = dummy;
        dummy.next = head;
        while (curr != null) {
            if (curr.val == val) 
                prev.next = curr.next;
            else
                prev = prev.next;
            curr = prev.next;
        }
        return dummy.next;
        */
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}