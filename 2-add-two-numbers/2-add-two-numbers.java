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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode list3 = new ListNode(0);
        
        ListNode l3 = list3;
        
        int reminder = 0;
        while(list1 != null && list2 != null){
            
            int sum = reminder + list1.val + list2.val;
            reminder = 0;
            if(sum > 9){
                
                reminder = (sum-(sum%10))/10;
                // Keep Last digit
                sum = sum%10;
                
            }
            
           

            list3.next = new ListNode(sum);

            
            list1 = list1.next;
            list2 = list2.next;
            list3 = list3.next;
            
        }
        
        while(list1 != null){
            
            int sum = reminder + list1.val;
            reminder = 0;
            if(sum > 9){
                
                reminder = (sum-(sum%10))/10;
                // Keep Last digit
                sum = sum%10;
                
            }

            list3.next = new ListNode(sum);

            list1 = list1.next;
            list3 = list3.next;
            
        }
        
        while(list2 != null){
            
            int sum = reminder + list2.val;
            reminder = 0;
            if(sum > 9){
                
                reminder = (sum-(sum%10))/10;
                // Keep Last digit
                sum = sum%10;
                
            }

            list3.next = new ListNode(sum);

            list2 = list2.next;
            list3 = list3.next;
            
        }
        
        if(reminder > 0){
            list3.next = new ListNode(reminder);
        }
        
        return l3.next;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)