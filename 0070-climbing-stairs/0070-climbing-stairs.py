class Solution:
    def climbStairs(self, n: int) -> int:
        self.t = {}
        return self.climb(n)

    def climb(self, n: int) -> int:
        if n <= 0:
            return 0
        if n == 2:
            return 2
        if n == 1:
            return 1
        if n in self.t:
            return self.t[n]
        self.t[n] = self.climb(n-1) + self.climb(n-2)
        return self.t[n]