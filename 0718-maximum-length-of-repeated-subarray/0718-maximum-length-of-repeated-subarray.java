class Solution {

    private int[][] t;
    private int result = Integer.MIN_VALUE;

    public int findLength(int[] nums1, int[] nums2) {
        int rows = nums2.length+1, cols = nums1.length+1;
        t = new int[cols][rows];
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));
        LCS(nums1, nums2, nums1.length, nums2.length);
        return result;
    }

    private int LCS(int[] nums1, int[] nums2, int l1, int l2){
        if (l1 == 0 || l2 == 0){
            return 0;
        }

        if(t[l1][l2] != -1){
            return t[l1][l2];
        }

        if(nums1[l1-1] == nums2[l2-1]){
            t[l1][l2] = 1 + LCS(nums1, nums2, l1-1, l2-1);           
        } else {
            t[l1][l2] = 0;
        }
        LCS(nums1, nums2, l1-1, l2);
        LCS(nums1, nums2, l1, l2-1);
        result = Math.max(t[l1][l2], result);
        return t[l1][l2];
    }
}