class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] s = new char[n];
        
        // Step 1: Fill with placeholder
        for (int i = 0; i < n; i++) {
            s[i] = '#';
        }
        
        char ch = 'a';
        
        // Step 2: Assign characters
        for (int i = 0; i < n; i++) {
            if (s[i] == '#') {
                if (ch > 'z') return "";
                
                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        s[j] = ch;
                    }
                }
                ch++;
            }
        }
        
        // Step 3: Validate LCP matrix
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                
                if (dp[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }
        
        return new String(s);
    }
}