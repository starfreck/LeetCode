class Solution {
    // Class-level memoization table
    private Integer[][] memo;
    private int[] prices;
    private int fee;
    
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        
        // Initialize memoization table: day × holding status
        // memo[day][0] = max profit from day when not holding stock
        // memo[day][1] = max profit from day when holding stock
        memo = new Integer[prices.length][2];
        
        // Start recursion from day 0 with no stock
        return maxProfitFromDay(0, 0);
    }
    
    /**
     * Calculate maximum profit starting from a given day with a given holding status
     * @param day Current day index
     * @param hasStock 0 = not holding stock, 1 = holding stock
     * @return Maximum possible profit
     */
    private int maxProfitFromDay(int day, int hasStock) {
        // Base case: reached the end of timeline
        if (day >= prices.length) {
            return 0;
        }
        
        // Return cached result if available
        if (memo[day][hasStock] != null) {
            return memo[day][hasStock];
        }
        
        // Option 1: Skip this day (do nothing)
        int skipDay = maxProfitFromDay(day + 1, hasStock);
        
        // Option 2: Buy or sell based on current holding status
        int buyOrSell;
        if (hasStock == 0) {
            // Not holding → buy stock (spend money = negative profit)
            buyOrSell = -prices[day] + maxProfitFromDay(day + 1, 1);
        } else {
            // Holding → sell stock (gain money minus fee = positive profit)
            buyOrSell = prices[day] - fee + maxProfitFromDay(day + 1, 0);
        }
        
        // Choose the more profitable option
        int result = Math.max(skipDay, buyOrSell);
        
        // Cache the result before returning
        memo[day][hasStock] = result;
        return result;
    }

    // Method: 2
    // public int maxProfit(int[] prices, int fee) {
    //     int profit = 0;
    //     int[] buy = new int[prices.length];
    //     buy[0] = prices[0];
    //     for(int i=1; i < prices.length; i++) {
    //         buy[i] = Math.min(buy[i-1], prices[i]-profit);
    //         profit = Math.max(profit, prices[i]-buy[i-1]-fee);
    //     }
    //     return profit;
    // }
}