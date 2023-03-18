class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        
        // O(n)
        for(int i = 0; i < numbers.length; i++ ){
            
            // O(n log n)
            int num2Index = binarySearch(numbers,target-numbers[i]);
            
            if(num2Index != -1){
                
                // If it is a same number then skip
                if(i == num2Index){
                    continue;
                }
                
                if(num2Index > i){
                    return new int[] {i+1,num2Index+1};
                } else{
                    return new int[] {num2Index+1,i+1};
                }

            }
        }
        return null;
    }


    private int binarySearch(int[] arr, int target){

        int i = 0;
        int j = arr.length-1;


        while(i <= j){

            int mid = (i+j)/2;

            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] > target){
                j = mid-1;
            } else {
                i = mid+1;
            }
        }

        return -1;
    }
}
// Time Complexity: O(n^2 log n)
// Space Complexity: O(1)