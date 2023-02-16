class Solution {

    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;

    int index1 = 0;
    int index2 = 0;

    int amountOfWater = -1;

    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length-1;

        index1 = i;
        index2 = j;

        while(i < j){
            
            if(height[i] > max1){
                max1 = height[i];
                index1 = i;
            }

            if(height[j] > max2){
                max2 = height[j];
                index2 = j;
            }

            int newAmountOfWater = Math.min(max1,max2) * (index2 - index1);
            if(newAmountOfWater > amountOfWater){
                amountOfWater = newAmountOfWater;
            }

            if(height[i] > height[j]){
                 j--;
            } else{
                i++;
            }
           
        }
        return amountOfWater;
    }
}
// Time Complexity : O(n)
// Space Complexity : O(1)