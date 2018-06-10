/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode walker = head, runner = head;
        while (runner != null && runner.next != null) {
            runner = runner.next.next;  // runner moves by 2 nodes
            walker = walker.next;
        }
        // if even # of nodes in list, runner now is pointing at null, walker is pointing at the head of the 2nd half of list
        // if odd # of nodes in list, runner is pointing at the last node, walker is pointing at the middle node
        // you'll see the coneniece of making the 2nd half shorter for the odd # case
        if (runner != null) {
            walker = walker.next;   // walker is always the head of the 2nd half
        }
        walker = reverseList(walker);
        runner = head;  // reassign head to runner, now runner will traverse the 1st half of the list slowly
        while(walker != null) {  // loop is done when the 2nd half is finished traversing
            if (walker.val != runner.val) 
                return false;
            walker = walker.next;
            runner = runner.next;
        }
        return true;
    }
    
    private ListNode reverseList (ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}