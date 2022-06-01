class Solution {
    public boolean isPalindrome(String s) {
        
        char[] arr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","").toCharArray();
    
   
        
        int i = 0;
        int j = arr.length-1;
        boolean flag = true;
        while(i <= j){
            
            if(arr[i] != arr[j]){        
                flag = false;
                break;
            }
            
            i++;
            j--;
            
        }
        
        return flag;
        
        
        
    }
}