class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int product = 1;
        int[] result = new int[nums.length];
        
        int i = 0;
        while(i < nums.length){
            result[i] = product;
            product = product * nums[i];
            i++;
        }

        product = 1;
        i = nums.length-1;
        while(i >= 0){
            result[i] = result[i] * product;
            product = product * nums[i];
            i--;
        }

        return result;
    }
}
// Time Complexity : O(n)
// Space Complexity : O(n)
// https://andrewsullivan.co/articles/2021/9/2/algorithms-product-of-array-except-self