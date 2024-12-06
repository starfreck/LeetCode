from bisect import bisect_right,bisect_left

class Solution:
    # TC: O(n) due to looping over [1,n]
    # SC: O(n) due to hashmap
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        count = 0
        banned = set(banned)
        for i in range(1, n+1):
            if i in banned:
                continue
            if maxSum-i < 0:
                return count
            maxSum -= i
            count += 1
        return count