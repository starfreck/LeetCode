class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        
        
        Map map = new HashMap<Integer,Integer>();
        
 
        for(int i = 0 ; i < nums.length; i++){
            
            if(map.containsKey(target-nums[i])){
                
                return new int[] { i, (Integer) map.get(target-nums[i]) };
                
            } else{
                
                map.put(nums[i],i);
                
            }

        }
        
        return null;
        
    }
}