class Solution {
    
    int[] nums;
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return result;
    }
    
    private void dfs(int i){
        
        if(i >= this.nums.length){
            result.add(new ArrayList(this.list));
            return;
        }
        
        // DFS with
        this.list.add(this.nums[i]);
        dfs(i+1);
        
        // DFS without 
        this.list.remove(Integer.valueOf(this.nums[i]));
        dfs(i+1);
    }
}
// Time Complexity: O(n * 2^n)