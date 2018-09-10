/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
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
