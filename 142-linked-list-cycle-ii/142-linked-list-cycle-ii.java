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
public class Solution {

    // Time Complexity will be O(n)
    // Space Complexity will be O(n)
    Set<ListNode> set = new HashSet();
    public ListNode detectCycle(ListNode head) {
        
        while(head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}