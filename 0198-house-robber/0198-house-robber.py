class Solution:
    def rob(self, nums: List[int]) -> int:
        self.t = [-1] * len(nums)
        return self.robFrom(nums,0)

    def robFrom(self, wealth: List[int], house: int) -> int:
        if house >= len(wealth):
            return 0
        
        if self.t[house] != -1:
            return self.t[house]
        
        robCurrentHouse = wealth[house] + self.robFrom(wealth, house+2)
        
        robNextHouse = self.robFrom(wealth, house+1)
        
        self.t[house] = max(robCurrentHouse, robNextHouse)
        
        return self.t[house]