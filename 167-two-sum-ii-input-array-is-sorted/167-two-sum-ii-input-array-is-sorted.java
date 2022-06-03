class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        
        int[] output = new int[2];
        
        int i = 0;
        int j = numbers.length-1;
        
        while(i < j){
            
            int sum = numbers[i] + numbers[j];

            if(sum == target){
                output[0] =  i+1;
                output[1] = j+1;
                break;
            } else if(sum < target){
                i++;
            } else {
                j--;
            }
        }
        
        return output;
    }
}