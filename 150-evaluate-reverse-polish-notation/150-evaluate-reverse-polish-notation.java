class Solution {
    
    public int evalRPN(String[] tokens) {
        
        Stack<String> stack = new Stack<>();
        
        for(String c : tokens) {
            
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());

                if(c.equals("+")){ 
                     stack.push(String.valueOf(a+b));
                } else if(c.equals("-")){
                    stack.push(String.valueOf(a-b));
                } else if(c.equals("/")){              
                    stack.push(String.valueOf(a/b));
                } else if(c.equals("*")){
                    stack.push(String.valueOf(a*b));
                }
                
            } else {
                stack.push(c);
            }
        }
                    
        return Integer.valueOf(stack.pop());
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)