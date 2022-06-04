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
    public void reorderList(ListNode head) {
        
        
        ListNode node = head;
        // Count the total size of linked list
        int size = 0;
        while(node != null){
            node = node.next;
            size++;
        }
        
        node = head;
        
        int halfSize = size/2;
        
        // Find the mid point to dived into 2 parts 
        for(int i = 0 ; i < halfSize; i++){
            node = node.next;
        }
        
        ListNode list1 = head;
        ListNode list2 =  node.next;
        
        // Spliting the list into 2 parts
        node.next = null;
        // Reverse the half linked list
        list2 = reverLinkedList(list2);
        
        int count = 1;
        ListNode list = new ListNode();
        while(list1 != null && list2 != null){
            
            if(count % 2 == 0){
                list.next = list2;
                list2 = list2.next;
                list = list.next;
            } else{
                list.next = list1;
                list1 = list1.next;
                list = list.next;
            }
            
            count++;
        }
        
        while(list1 != null){
            list.next = list1;
            list1 = list1.next;
            list = list.next;
        }
        // Useless still adding it
        while(list2 != null){
            list.next = list2;
            list2 = list2.next;
            list = list.next;
        }
        
        head = list.next;
     
    }
    
    
    public ListNode reverLinkedList(ListNode head){
        
        if(head == null || head.next == null){
            return head;
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
        
        return head;
        
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)