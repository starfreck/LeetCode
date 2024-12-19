class Solution:
    # TC: O(n) where 'n' is number of elements in prices
    # SC: O(n) where 'n' is number of elements in stack
    
    # Here we are using a monotonic stack in increasing order
    # to keep track of all future values
    def finalPrices(self, prices: List[int]) -> List[int]:
        stack = []
        answer = [0] * len(prices)

        for i in range(len(prices)-1,-1,-1):
            # If the stack is not None and top element is > current prices
            # pop the top since we cannot apply the discount 
            while stack and prices[i] < stack[-1]:
                stack.pop()
            # If the stack is not None and top element is <= current prices
            # than apply the discount 
            if stack and prices[i] >= stack[-1]:
                answer[i] = prices[i] - stack[-1]
            # Do not apply the discount
            else:
                answer[i] = prices[i]
            # add currently processed price
            stack.append(prices[i])
        return answer

