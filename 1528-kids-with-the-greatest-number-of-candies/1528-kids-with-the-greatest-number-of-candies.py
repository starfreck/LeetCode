class Solution:
    # TC: O(n)
    # SC: O(n)
    # For each kid check if candies[i] + extraCandies ≥ maximum in Candies[i]
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        result = [False] * len(candies)
        maxCandies = 0
        for c in candies:
            maxCandies = max(c, maxCandies)        
        for i in range(len(candies)):
            if candies[i]+extraCandies >= maxCandies:
                result[i] = True
        return result