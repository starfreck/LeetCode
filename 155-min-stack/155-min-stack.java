class MinStack {
    
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    // O(1)
    public void push(int val) {
        
        if(val < min){
            min = val;
        }
        
        stack.push(val);
    }
    
    // O(n)
    public void pop() {
        int pop =stack.pop();
        // Find new min
        if(min == pop){
            min = Integer.MAX_VALUE;
            for(int i : stack){
                if(i < min){
                    min = i;
                }
            }
        }
    }
    
    // O(1)
    public int top() {
        return stack.peek();
    }
    
    // O(1)
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */