class MyStack:

    def __init__(self):
        self.q1 = []
        self.q2 = []
        self.isQ1InUse = True    

    def push(self, x: int) -> None:
        if self.isQ1InUse:
            self.q1.append(x)
        else:
            self.q2.append(x)

    def pop(self) -> int:
        if self.isQ1InUse:
            self.isQ1InUse = not self.isQ1InUse    
            while len(self.q1) > 1:
                self.push(self.q1.pop(0))
            return self.q1.pop(0)
        else:
            self.isQ1InUse = not self.isQ1InUse
            while len(self.q2) > 1:
                self.push(self.q2.pop(0))
            return self.q2.pop(0)

    def top(self) -> int:
        if self.isQ1InUse:
            return self.q1[len(self.q1)-1]
        else:
            return self.q2[len(self.q2)-1]

    def empty(self) -> bool:
        if len(self.q1) == 0 and len(self.q2) == 0:
            return True
        else:
            return False

# Q1: How to pop from the last element?
#   self.q1.pop()
# Q2: How to pop element from a particular index?
#   self.q1.pop(index)
# Q3: How to invert bool in python?
#   self.isQ1InUse = not self.isQ1InUse 
#   True == not False   

# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()