class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int localMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < localMin) {
                localMin = prices[i];
            } else if (prices[i] - localMin > maxProfit) {
                maxProfit = prices[i] - localMin;
            }
        }
        return maxProfit;
    }
}