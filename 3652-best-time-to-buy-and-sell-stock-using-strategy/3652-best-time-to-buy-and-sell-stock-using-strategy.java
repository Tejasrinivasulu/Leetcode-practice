class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
         int n = prices.length;

        long originalProfit = 0;
        for (int i = 0; i < n; i++) {
            originalProfit += (long) strategy[i] * prices[i];
        }

        // prefix sum of old strategy profit
        long[] prefOld = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefOld[i + 1] = prefOld[i] + (long) strategy[i] * prices[i];
        }

        // prefix sum of prices
        long[] prefPrice = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefPrice[i + 1] = prefPrice[i] + prices[i];
        }

        int half = k / 2;
        long maxGain = 0;

        for (int l = 0; l + k <= n; l++) {
            int r = l + k;

            // old contribution in window
            long oldSum = prefOld[r] - prefOld[l];

            // new contribution: only last k/2 are sells
            long newSum = prefPrice[r] - prefPrice[l + half];

            long gain = newSum - oldSum;
            maxGain = Math.max(maxGain, gain);
        }

        return originalProfit + maxGain;
    }
}