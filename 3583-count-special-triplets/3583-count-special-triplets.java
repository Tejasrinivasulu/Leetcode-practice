class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long MOD = 1_000_000_007;
        
        // Use arrays for O(1) constant time access since max value is 10^5
        // We need size 200,001 because targetVal (nums[j]*2) can reach 200,000
        int[] leftFreq = new int[200001];
        int[] rightFreq = new int[200001];
        
        // 1. Pre-fill the right frequency array (suffix counts)
        for (int num : nums) {
            rightFreq[num]++;
        }
        
        long totalTriplets = 0;
        
        // 2. Iterate through as index 'j' being the middle element
        for (int j = 0; j < n; j++) {
            int currentVal = nums[j];
            int targetVal = currentVal * 2;
            
            // Remove current nums[j] from right counts so it's not counted as 'k'
            rightFreq[currentVal]--;
            
            // If the target (2 * nums[j]) exists on both sides, add to result
            // Check targetVal < 200001 is technically redundant due to nums[i] constraints
            // but keeps the code safe from index out of bounds.
            if (targetVal <= 200000) {
                long leftCount = leftFreq[targetVal];
                long rightCount = rightFreq[targetVal];
                
                if (leftCount > 0 && rightCount > 0) {
                    totalTriplets = (totalTriplets + (leftCount * rightCount)) % MOD;
                }
            }
            
            // Add current nums[j] to left counts for the next iteration
            leftFreq[currentVal]++;
        }
        
        return (int) totalTriplets;
    }
}