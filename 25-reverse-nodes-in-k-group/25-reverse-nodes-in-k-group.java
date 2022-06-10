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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode result = null;
        ListNode tail = null;
        
        ListNode node = head;
        
        ListNode start = head;
        
        ListNode end = null;
        
        int counter = 1;
        
        while(node != null){
            
            if(counter == 1){
                start = node;
            }
            
            if(counter == k){
                end = node;
            }
            
            if(start != null && end != null){
                
                // Move Node to next
                node = node.next;
                end.next = null;
                
                ListNode[] nodes = reverseList(start);
                // Store Head
                if(result == null){
                    result = nodes[0];
                    tail = nodes[1];
                } else {
                    tail.next = nodes[0];
                    tail = nodes[1];
                }

                start = null;
                end = null;
                counter = 1;
                continue;
            }
            
            node = node.next;
            counter++;
        }
        
        if(start != null){
            tail.next = start;
        }
        return result;
    }
    
    
    private ListNode[] reverseList(ListNode head){
        
        if(head == null){
            return null;
        }
        
        if(head.next == null){
            return new ListNode[]{head,head};
        }
        
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        
        p1.next = null;
        while(p3 != null){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        head = p2;
        
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        
        return new ListNode[]{head,tail};
        
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)