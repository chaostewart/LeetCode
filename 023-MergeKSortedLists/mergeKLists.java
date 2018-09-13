/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
Time complexity : O(Nlog k) where k is the number of linked lists.
We can merge two sorted linked list in O(n) time where n is the total number of nodes in two lists.
Sum up the merge process and we can get: O(Nlog k) where N is the total number of nodes in k lists
Space complexity : O(1)
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
        // sol 1: use PriorityQueue
        if (lists == null || lists.length == 0) 
            return null;
        
        // the size of queue is always the length of input lists, k,  so time complexity is: O(nlogk)
        // listnodes are sorted in ascending order of ListNode.val
        Queue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (n1, n2) -> n1.val - n2.val);
        
        ListNode dummy = new ListNode(-1);   // result
        ListNode pointer = dummy;     // pointer will move along the queue and each listnode
        
        for (ListNode node:lists)
            if (node != null)
                queue.add(node);    // push all nodes(heads) to the queue
            
        while (!queue.isEmpty()) {
            pointer.next = queue.poll();    // pointer adds the smallest node on the queue to the end of dummy
            pointer = pointer.next;       
            if (pointer.next != null)
                queue.add(pointer.next);      // push the smallest node's next node to the queue
        }
        
        return dummy.next;
*/

    // sol2: recurse on mergeTwoLists(), way faster!
   public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) 
            return null;
        return merge(lists, 0, lists.length - 1);
    }
    
    // break a k-list to many two-lists
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];
        int mid = start + (end - start) / 2;
        ListNode list1 = merge(lists, start, mid);
        ListNode list2 = merge(lists, mid + 1, end);   // don't duplicate mid list! 
        // merge list1 and list2
        return mergeTwoLists(list1, list2);
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = list1, p2 = list2, p = dummy;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = p1 == null ? p2 : p1;
        return dummy.next;
    }

}
