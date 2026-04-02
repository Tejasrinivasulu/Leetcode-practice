import java.util.*;

class Solution {
    public int maximumAmount(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][3];

        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MIN_VALUE);
            }
        }

        // Starting point
        dp[0][0][0] = grid[0][0];
        if (grid[0][0] < 0) {
            dp[0][0][1] = 0; // skip first cell
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {

                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    // Move Right
                    if (j + 1 < n) {
                        int val = grid[i][j + 1];

                        // Take value
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + val);

                        // Skip negative
                        if (val < 0 && k < 2) {
                            dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1], dp[i][j][k]);
                        }
                    }

                    // Move Down
                    if (i + 1 < m) {
                        int val = grid[i + 1][j];

                        // Take value
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + val);

                        // Skip negative
                        if (val < 0 && k < 2) {
                            dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1], dp[i][j][k]);
                        }
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int k = 0; k < 3; k++) {
            result = Math.max(result, dp[m - 1][n - 1][k]);
        }

        return result;
    }
}