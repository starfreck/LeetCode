class Solution {
    
    
    
    public int lengthOfLongestSubstring(String s) {
        
        char[] chars = s.toCharArray();
        
        int l = 0;
        int result = 0;
        
        Set<Character> set = new HashSet<>();
        
        for(int r = 0; r < chars.length; r++){
            
            while(set.contains(chars[r])){
                set.remove(chars[l]);
                l++;
            }
            
            set.add(chars[r]);
            
            result = Math.max(result,r-l+1);
            
        }
        
        return result;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)