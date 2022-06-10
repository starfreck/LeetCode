class Solution {
    
    // Follow Up: Do it with O(1) space
    
    Stack<Character> stack = new Stack<>();
    
    public boolean isValid(String s) {
        
        for(char c : s.toCharArray()){
            
            if( c == '(' || c == '{' || c == '[' ){
                stack.push(c);
                
            } else if( c == ')' || c == '}' || c == ']' ){
                char pop = ' ';
                try{
                    pop = stack.pop();
                } catch(Exception e){
                    
                }
                if(pop == '(' && c == ')'){
                    continue;
                } else if(pop == '{' && c == '}'){
                    continue;
                } else if(pop == '[' && c == ']'){
                    continue;
                } else {
                    return false;
                } 
            }
        }
        
        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)