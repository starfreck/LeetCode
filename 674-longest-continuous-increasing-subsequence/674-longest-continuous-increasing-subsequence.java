class Solution {

    int max = Integer.MIN_VALUE;
    int i = 1;
    int j = 0;

    public int findLengthOfLCIS(int[] nums) {

        while(i < nums.length){
            
            if(nums[i-1] >= nums[i]){
                // Reset the max
                max = Math.max(max,i-j);
                j = i;
            }

            i++;
        }

        max = Math.max(max,i-j);

        return max; 
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)