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
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr = head;
        
        // 1st loop copies all nodes with labels, map <inputNode, copiedNode>
        while(curr != null) {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }
        curr = head;
        // 2nd loop connects all nodes with .next and .random.   get<Key> = <Value> ---> get<inputNode> = copiedNode
        while(curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}