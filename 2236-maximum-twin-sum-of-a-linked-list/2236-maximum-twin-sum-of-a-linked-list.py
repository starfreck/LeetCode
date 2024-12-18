# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        
        # TC: O(n), SC: O(1)
        def findMid(node: ListNode):  # TC: O(n), SC: O(1)
            prev = curr = node
            while curr != None:
                prev = prev.next
                curr = curr.next.next
            return prev

        def reverseLinkedList(node: ListNode):  # TC: O(n), SC: O(1)
            prev, curr = None, node
            while curr != None:
                tmp = curr.next
                curr.next = prev
                prev = curr 
                curr = tmp
            return prev
        
        def printLinkedList(node: ListNode):  # TC: O(n), SC: O(1)
            curr = node
            string = ""
            while curr != None:
                string += str(curr.val) + "->"
                curr = curr.next
            print(string)

        if head == None: return 0

        # Find the mid
        mid = findMid(head)
        # Reverse the LinkedList from Mid
        l2 = reverseLinkedList(mid)
        l1 = head
        # Do the SUM and keep increasing the count and keep checking the MAX
        MAX = float("-inf")
        c1, c2 = l1, l2

        while c2 != None: # TC: O(n)
            MAX = max(MAX, c1.val + c2.val)
            c1 = c1.next
            c2 = c2.next
        return MAX