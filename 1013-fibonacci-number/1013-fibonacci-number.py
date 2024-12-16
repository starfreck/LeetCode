class Solution:

    def fib(self, n: int) -> int:
        memo = {0:0,1:1}

        def fibonacci(n):
            if n in memo:
                return memo[n]
            result = fibonacci(n-1) + fibonacci(n-2)
            memo[n] = result
            return result

        return fibonacci(n)