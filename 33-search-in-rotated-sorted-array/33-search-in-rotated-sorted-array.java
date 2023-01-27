class Solution {
    public int search(int[] nums, int target) {

        int orignalStart = 0;

        // Step 1: Find Orignal Starting point
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            
            int mid = (start+end)/2;
            
            if(mid+1 <= nums.length && nums[mid] > nums[mid+1]){
                orignalStart =  mid+1;
                break;
            } else if(mid > 0 && nums[mid-1] > nums[mid]){
                orignalStart =  mid;
                break;
            } else if(nums[mid] >  nums[nums.length-1]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    
        
        // Step 2: Find the given target
        start = 0;
        end = nums.length-1;
        while(start <= end){
                
            int mid = (start+end)/2;
            int realMid = (mid + orignalStart) % nums.length;

            if(target == nums[realMid]){
                return realMid;
            } else if(nums[realMid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return -1;
        
    }
}
// Time Complexity: O(log n)