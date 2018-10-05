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
        // if it's an empty list or it has reached the last node in list
        if (head == null || head.next == null) 
            return head; //return the curr node
        // otherwise, reverse the rest of the linked list, the returned p is the last node in list
        ListNode p = reverseList(head.next);    
        //after the rest has been reversed, it looks like ...-->node_i(head)-->node_i+1(head.next)<--node_i+2<--node_i+3...
        // and node_i+1's next points to NULL
        head.next.next = head;   
        head.next = null;
        return p;
    }      
}


