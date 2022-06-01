class Solution {
    
    
    
     // Time: O(n)
     // Space: O(n)
     public int longestConsecutive(int[] nums) {
         
         
         Set set = new HashSet<Integer>();
         
         for(int num : nums)
         {
             set.add(num);
         }
            
         int longest = 0;
         
         for(int num : nums)
         {
            
             // Check if it is the starting of the squence
             if(!set.contains(num-1))
             {
                 
                 int length = 0;
                 int i = num;
                 while(set.contains(i))
                 {
                    length++; 
                    i++;
                 }
                
                 longest = Math.max(longest,length);
             }
             
             
         }
         
         return longest;
     }
    
    // Time Limit Exceeded
    int longestConsecutiveSolutionOne(int[] nums) {
        
        int output = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map map = new HashMap<Integer,Integer>();
        
        for(int i : nums){
            
            if(i > max){
                max = i;
            }
            
            if(i < min){
                min = i;
            }
            
            map.put(i,i);
            
        }

        int count = 0;

        for(int k = min; k <= max; k++){
            
            if(!map.containsKey(k)){
                if(count > output){
                    output = count;
                }
                count = 0;
            } else{
                count++;
            }
        }
        
        if(count > output){
            output = count;
        }
        
        return output;
    }
}