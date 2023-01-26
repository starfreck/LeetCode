class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            
            int mid = (start+end)/2;
            
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            } else if(mid-1 < 0 || nums[mid-1] > nums[mid]){
                return nums[mid];
            } else if (nums[mid] > nums[nums.length-1]){
                start = mid +1; 
            } else{
                end = mid-1;
            }
        }

        return -1;
    }
}

// Time Complexity: O(log n)