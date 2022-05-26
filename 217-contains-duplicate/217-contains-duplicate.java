class Solution {
    
    Map map = new HashMap<Integer,Boolean>();
    boolean flag = false;
    
    public boolean containsDuplicate(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
            
            if(map.get(nums[i]) == null){
                map.put(nums[i],true);
            } else {
                return true;
            }
        }
        
        return false;
    }
}