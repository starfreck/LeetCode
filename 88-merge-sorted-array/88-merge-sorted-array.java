class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // 1,4,6,0,0,0
        // 5,2,3
        int index =  m;
        
        for(int i: nums2){
            nums1[index] = i;
            index++;
        }
        Arrays.sort(nums1);
    }
}