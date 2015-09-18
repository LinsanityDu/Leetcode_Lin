/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).*/


// My Suck Code
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        // Left 
        int[] left = new int[prices.length];
        int localMin = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            localMin = Math.min(localMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - localMin);
            left[i] = maxProfit;
        }
        
        // Right
        int[] right = new int[prices.length];
        int localMax = Integer.MIN_VALUE;
        maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            localMax = Math.max(localMax, prices[i]);
            maxProfit = Math.max(maxProfit, (-1) * (prices[i] - localMax));
            right[i] = maxProfit;
        }
        
        maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }
}



// Discussion Solution
public class Solution {
    public int maxProfit(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for(int i = 0; i < prices.length; i++){
            oneBuy = Math.max(oneBuy, -prices[i]);//we set prices to negative, so the calculation of profit will be convenient
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] + oneBuy);
            twoBuy = Math.max(twoBuy, oneBuyOneSell - prices[i]);//we can buy the second only after first is sold
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + prices[i]);
        }
        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }
}