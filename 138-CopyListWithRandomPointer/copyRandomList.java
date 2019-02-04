/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
/*
The idea is to associate the original node with its copy node in a single linked list. In this way, we don't need extra space to keep track of the new nodes.
The algorithm is composed of the follow three steps which are also 3 iteration rounds.

Iterate the original list and duplicate each node. The duplicate
of each node follows its original immediately.
Iterate the new list and assign the random pointer for each
duplicated node.
Restore the original list and extract the duplicated nodes.
*/
// Space: O(1), Time: O(n)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode curr = head, next = null;
        // 1st round: make a copy of each node, and link them together side-by-side in a single list.
        while (curr != null) {
            next = curr.next;
            RandomListNode copy = new RandomListNode(curr.label);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }
        
        curr = head;
        //2nd round: assign random pointers for the cloned nodes.
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode currCopy = dummy;
        curr = head;
        //3rd round: restore the original list, and extract the cloned list.
        while (curr != null) {
            next = curr.next.next;
            currCopy.next = curr.next;
            currCopy = currCopy.next;
            curr.next = next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
/*
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        // Map<originalNode, copiedNode>
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();  
        RandomListNode curr = head;
        
        // 1st loop make copies of all nodes and their labels, and maps each orignal node with its copy  
        while(curr != null) {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        curr = head;
        // 2nd loop connects all nodes with .next and .random.   
        // get<Key> = <Value> ---> get<originalNode> = copiedNode
        while(curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
*/
