class Solution:


    # SC: O(n)
    # TC: O(n)
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # check if the target-num exist in seen
        # if not add num in seen
        # else return True
        # return false if it doesn't exist
        seen = dict()
        for i in range(len(nums)):
            if target-nums[i] in seen:
                return [seen[target-nums[i]],i]
            else:
                seen[nums[i]]=i

    # SC: O(n)
    # TC: O(n log n)
    def twoSumT1(self, nums: List[int], target: int) -> List[int]:
        # sort an array, O(n log n)
        # use 2 pointers one from start and another from the end
        # keep adding the numbers which are located at pointers
        # if the sum is less than the target then increase left pointer
        # if the sum is greater than the target then decrease right pointer
        # stop if 2 pointers cross each other
        arr = nums.copy()
        nums.sort() # O(n log n)
        left, right = 0, len(nums)-1
        values = []
        indexes = []
        while left < right: # O(n)
            sum = nums[left] + nums[right] 
            if sum == target:
                return [arr.index(nums[left]), arr.index(nums[right])]
            elif sum > target:
                right -= 1
            else:
                left += 1
        return []
            