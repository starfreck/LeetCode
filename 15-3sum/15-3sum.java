class Solution {
    
    List<List<Integer>> result =  new ArrayList<List<Integer>>();
    
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        if(nums.length < 3){
            return result;
        }
        
        // Sort -> O(n log n)
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            // O(n)
            twoSum(nums,i+1,nums[i]);
            
        }
        
        return result;
    }
    
    
    public void twoSum(int[] nums, int start, int sum){
        
        int i = start;
        int j = nums.length-1;
        
        while(i < j){
            
            int total = nums[i] + nums[j];
            
            if(sum+total == 0){
                // Add to the list
                List<Integer> list = new ArrayList<Integer>();
                list.add(sum);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                
                // Update i to keep looking for the other vaules
                i++;
                // Skip the repeated numbers to Avoid Duplicates in the final result
                while(i < j && nums[i-1] == nums[i]){
                    i++;
                }
                
            } else if(sum+total < 0){
                i++;
            } else{
                j--;
            }
            
        }
    }
}
// Time Complexity: O(n log n) * O(n) -> O(n^2 log n) -> O(n^2)
// Space Complexity: O(n)