class Solution {
    public int countPermutations(int[] complexity) {
         final int MOD = 1_000_000_007;
        int n = complexity.length;
        
        // Check if every other computer can be unlocked
        // All complexity[i] (i > 0) must be > complexity[0]
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0; // impossible to unlock all
            }
        }
        
        // If possible, answer = (n-1)! % MOD
        long ans = 1;
        for (int i = 1; i <= n - 1; i++) {
            ans = (ans * i) % MOD;
        }
        
        return (int) ans;
    }
}