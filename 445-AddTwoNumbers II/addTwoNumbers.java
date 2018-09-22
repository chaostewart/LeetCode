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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode n1 = l1, n2 = l2;
        
        while (n1 != null) {
            s1.push(n1.val);
            n1 = n1.next;
        }
        while (n2 != null) {
            s2.push(n2.val);
            n2 = n2.next;
        }
        
        int sum = 0;
        ListNode node = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            sum /= 10;
            if (!s1.isEmpty()) 
                sum += s1.pop();
            if (!s2.isEmpty()) 
                sum += s2.pop();
            node.val = sum % 10;
            ListNode head = new ListNode(sum / 10);  // the val of this head won't be used but replace by sum % 10 until the very end, i.e. of value 1 or 0
            head.next = node;
            node = head;
        }
        return node.val == 0 ? node.next : node;
    }
}