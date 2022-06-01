class Solution {
    
    public boolean isAnagram(String s, String t) {
        
        
        // If I will sort them and match 2 Arrays -> Time : O(n log n) Space :  O(n)
        // If I will use the HashMap and compare I may fail in cases like "aabc" , "abbc"
        // Since, HashMap Cannot handle duplicates well
        
        
        if(s.length() != t.length()){
            return false;
        }
        
        char[] sArr =  s.toCharArray();
        char[] tArr =  t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);
       
        for(int i = 0; i < sArr.length; i++){
            
            if(sArr[i] != tArr[i]){
                return false;
            }
            
        }
        
        return true;
        
    }
}

// Time Complexity : O(n log n)
// Space Complexity:  O(n)