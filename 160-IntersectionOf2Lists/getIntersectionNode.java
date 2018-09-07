/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// set two pointers, traverse both lists twice, once from A -> B, the other from B -> A
// two pointers will meet at the intersection, or never
// Time: O(n), Space: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;  // not needed, doesn't change run time
        ListNode a = headA, b = headB; 
        while (a != b) {
            // traverse both lists at most twice (if diff length)
            a = a == null ? headB : a.next;   // condition is tricky, check a == null instead of a.next == null
            b = b == null ? headA : b.next;   // which would result in exceeding time limit (endless loop)
        }
        return a;   // if no intersection, a = b = null
    }
    
}
