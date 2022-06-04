/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null || head.next == null){
            return null;
        }
        
        int size = 0;
        ListNode sizeNode = head;
        while(sizeNode != null){
            sizeNode = sizeNode.next;
            size++;
        }
        
        // Special case
        if(n == size){
            return head.next;
            
        }
        
        ListNode removeNode = head;
        int findNode = size-n;

        while(findNode != 1){
            removeNode = removeNode.next;
            findNode--;
        }
        
        
        // Removing the nth node
        removeNode.next = removeNode.next.next;
        
        return head;
    }
}

// Time Complexity:O(n)
// Space Complexity: O(1)