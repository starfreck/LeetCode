class Solution {
    
     // Time Complexity: O(n)
     // Space Complexity: O(1)
     public int maxProfit(int[] prices) {
        
        int profit = 0;
        int l = 0;
        for(int r = 1; r < prices.length; r++){
            
            if(prices[l] > prices[r]){
                l = r;
            } else{
                int localProfit = prices[r]-prices[l];
                profit = Math.max(localProfit,profit);
            }
           
        }
        
        return profit;
    }
    
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int maxProfitV1(int[] prices) {
        
        int profit = Integer.MIN_VALUE;
        
        for(int i = 0; i < prices.length; i++){
            
            for(int j = i; j < prices.length; j++){
                
                int currentProfit = prices[j]-prices[i];
                
                if(currentProfit > profit){
                    profit = currentProfit;
                }
            }
        }
        
        return profit;
    }
}
