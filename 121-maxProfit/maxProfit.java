class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) 
                min = prices[i];       // find "valleys"
            else if (prices[i] - min > maxProfit) 
                maxProfit = prices[i] - min;    // calculate if a following peak - a valley gives the max
        }
        return maxProfit;
    }
}