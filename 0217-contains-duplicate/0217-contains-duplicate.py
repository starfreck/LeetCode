# TC: O(n)
# SC: O(n)

class Solution:

    """
    TC: O(n) set(nums) will itrate through the list and create set from it
    SC: O(n) for the set of size n
    """
    def containsDuplicate(self, nums: List[int]) -> bool:
        if len(set(nums)) == len(nums):
            return False
        return True

    """
    TC: O(n)
    SC: O(n)
    """
    def containsDuplicateS1(self, nums: List[int]) -> bool:
        s = set() # O(n)
        for num in nums: # O(n)
            if num in s: # O(1)
                return True
            else:
                s.add(num) 
        return False