class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        int target = 0;

        // O(N log n)
        Arrays.sort(nums);

        HashSet<ArrayList<Integer>> output = new HashSet<ArrayList<Integer>>();
        
        // O(n)
        for(int i=0; i < nums.length; i++){
            
            int start = i+1;
            int end = nums.length-1;

            // O(n log n)
            while(start < end){
                
                int sum =  nums[start] + nums[end] + nums[i];

                if(sum == target){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    output.add(list);
                    start++;
                    end--;
                } else if (sum > target){
                    end--;
                } else{
                    start++;
                }
            }
        }

        return new ArrayList<>(output);
    }
}
// Time Complexity : O(n^2 log n)
// Space Complexity: O(n)