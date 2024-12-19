class RecentCounter:

    def __init__(self):
        self.req = collections.deque()        

    # TC: O(n)
    # SC: O(n)
    def ping(self, t: int) -> int:
        # Append a new ping to the end of req
        self.req.append(t)
        # check the abs diff with the current time from
        # the start of the queue and keep removing elements
        # where the diff is greater then 3000
        while abs(self.req[0]-t) > 3000:
            self.req.popleft()
        # Return the length of queue
        return len(self.req)



# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)