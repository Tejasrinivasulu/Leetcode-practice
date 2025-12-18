class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
         int n = prices.length;

        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        long maxProfit = baseProfit;

        long oldWindowSum = 0;
        long sellHalfSum = 0;

        for (int i = 0; i < n; i++) {
            oldWindowSum += (long) strategy[i] * prices[i];

            if (i >= k / 2) {
                sellHalfSum += prices[i];
            }

            if (i >= k) {
                oldWindowSum -= (long) strategy[i - k] * prices[i - k];
            }

            if (i >= k / 2 * 2) {
                sellHalfSum -= prices[i - k / 2];
            }

            if (i >= k - 1) {
                long newProfit = baseProfit - oldWindowSum + sellHalfSum;
                maxProfit = Math.max(maxProfit, newProfit);
            }
        }

        return maxProfit;
    }
}