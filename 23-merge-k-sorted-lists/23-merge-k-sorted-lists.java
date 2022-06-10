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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0){
            return null;
        }
        
        if(lists.length == 1){
            return lists[0];
        }
        
        ListNode l1 = lists[0];
        
        for(int i = 1; i < lists.length; i++){
            l1 = mergeTwoList(l1,lists[i]);
        }
        
        return l1;
    }
    
    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        
        ListNode mergedList = new ListNode();
        ListNode head = mergedList;
        
        while(l1 != null && l2 != null) {
            
            if(l1.val > l2.val){
                mergedList.next = l2;
                l2 = l2.next;
                mergedList = mergedList.next;
            } else {
                mergedList.next = l1;
                l1 = l1.next;
                mergedList = mergedList.next;
            }
        }
        
        if(l1 != null){
            mergedList.next = l1;
        }
        
        if(l2 != null){
            mergedList.next = l2;
        }
        
        return head.next;
    }
}
// Time Complexity: O(k*n) where n is the length of smallest list
// Space Complexity: O(1)