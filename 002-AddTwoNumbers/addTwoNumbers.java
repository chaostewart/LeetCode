/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(0); // keep the start of the list with a dummy header
        ListNode p = dummy;  //p is a pointer moving along the result list
        int sum = 0;
        while(c1 != null || c2 != null) {
            sum /= 10;  // sum is 1 or 0
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            p.next = new ListNode(sum%10);
            p = p.next;
        }
        if (sum/10 == 1) 
            p.next = new ListNode(1);
        
        return dummy.next;
    }
}
