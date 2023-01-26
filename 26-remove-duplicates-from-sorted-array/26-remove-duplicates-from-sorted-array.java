class Solution {
    public int removeDuplicates(int[] nums) {
        
        int previous = 0;
        
        for (int i=1; i <= nums.length-1; i++){

            if(nums[i] != nums[previous]){
                previous++;
                nums[previous] = nums[i];
               
            }
        }
        return previous+1;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)