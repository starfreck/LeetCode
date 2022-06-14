class Solution {
    
    Stack<String> ops;
    Stack<String> stack;
    
    public int evalRPN(String[] tokens) {
        
        ops = new Stack<String>();
        stack = new Stack<String>();
        
        for(int i = tokens.length-1; i >= 0; i--){
            ops.push(tokens[i]);
        }
        
        int ans = 0;
        
        while(!ops.isEmpty()){
            
            String pop = ops.pop();
            
            if(pop.equals("+") || pop.equals("-") || pop.equals("/") || pop.equals("*")){
                
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());

                
                if(pop.equals("+")){ 
                    stack.push(String.valueOf(b+a));
                } else if(pop.equals("-")){
                    stack.push(String.valueOf(b-a));
                } else if(pop.equals("/")){
                    // int v = b/a;              
                    stack.push(String.valueOf(b/a));
                } else if(pop.equals("*")){
                    stack.push(String.valueOf(b*a));
                }
                System.out.println(stack.peek());
            } else {
                //System.out.println(pop);
                stack.push(pop);
            }
        }
                    
        return Integer.valueOf(stack.pop());
    }
}