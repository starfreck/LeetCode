class Solution {
    public void rotate(int[][] matrix) {
        
        int left = 0;
        int right = matrix.length-1;
        
        
        while(left < right) {
            
            int numberOfRotationForLayer = right-left;
            
            for(int i = 0; i < numberOfRotationForLayer; i++){
                
                // Store A in the temp
                int temp = matrix[left][left+i];
                
                // Update A with B
                matrix[left][left+i] = matrix[right-i][left];

                // Update B with C
                matrix[right-i][left] = matrix[right][right-i];
                
                // Update C with D
                matrix[right][right-i] = matrix[left+i][right];
                
                // Update D with A
                matrix[left+i][right] = temp;
            }
            
            right--;
            left++;
            
        }
    }
}
// Time Complexity:O(N^2)
// Space Complexity: O(1)