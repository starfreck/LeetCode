class Solution {
    public int findDuplicate(int[] nums) {
        
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                return nums[i];
            }
        }

        return -1;
    }
}
// Time Complexity: O(n log n)
// SPace Complexity: O(1)