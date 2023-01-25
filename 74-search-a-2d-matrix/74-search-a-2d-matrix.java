class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // O(n)
        for(int i = 0;  i < matrix.length; i++){
            if(binarySearch(matrix[i],target)){
               return true; 
            }
        }   

        return false;
    }

    // O(log m)
    private boolean binarySearch(int[] array, int target){
        int start = 0;
        int end = array.length-1;
        
        while(start <= end){
            int mid = (start+end)/2;
            
            if(target == array[mid]){
                return true;
            } else if(target > array[mid]){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return false;
    }
}
// Time Complexity : O(n log m)