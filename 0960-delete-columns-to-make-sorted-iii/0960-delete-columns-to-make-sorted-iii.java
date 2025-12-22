class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] dp = new int[m];
        int maxKeep = 1;

        for (int j = 0; j < m; j++) {
            dp[j] = 1;
            for (int i = 0; i < j; i++) {
                boolean ok = true;
                for (int r = 0; r < n; r++) {
                    if (strs[r].charAt(i) > strs[r].charAt(j)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            maxKeep = Math.max(maxKeep, dp[j]);
        }

        return m - maxKeep;
    }
}