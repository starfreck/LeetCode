class Solution {
    
    
    public int[] buildArray(int[] nums) {
        
        int[] output = new int[nums.length];
        
        int c = 0;
        for(int i: nums){
            output[c] = nums[i];
            c++;
        }
        
        
        return output;
        
        
    }
}