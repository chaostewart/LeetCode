/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Observe that for a singly-linked list, if a loop exits, there's no tail node that has null as its next node
/* 
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seenNode = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {   // pointer curr hasn't reached the tail yet
            if (seenNode.contains(curr)) {     // if a node has been seen before
                return true;
            } else {
                seenNode.add(curr);   
                curr = curr.next;
            }
        }
        return false;
    }
}
*/

// O(1) space solution!! 
public class Solution {   
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;  // don't forget the special case
        ListNode walker = head;  // create two pointers, walker and runner. walker moves step by step 
        ListNode runner = head; // whereas runner moves by two steps
        while(runner.next != null && runner.next.next != null) {   // if runner is not the tail, stay in the loop
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {   // whether it's an odd loop or even loop, these two pointers will always meet
                return true;
            }
        }
        return false;
    }
}