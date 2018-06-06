/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* iterative solution
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;        
    }
}
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) // if it's an empty list or it has reached the last listnode
            return head; //return the curr pointer
        ListNode p = reverseList(head.next);    // otherwise, reverse the rest of the linked list
        //after the rest has been reversed, it looks like ...-->node_n(head)-->node_n+1(head.next)<--node_n+2<--node_n+3...
        head.next.next = head;   
        head.next = null;
        return p;
    }      
}


