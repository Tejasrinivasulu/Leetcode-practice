class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long MOD = 1_000_000_007;
        int[] leftFreq = new int[200001];
        int[] rightFreq = new int[200001];
        for (int num : nums) {
            rightFreq[num]++;
        }
        
        long totalTriplets = 0;
        
        for (int j = 0; j < n; j++) {
            int currentVal = nums[j];
            int targetVal = currentVal * 2;
            
            rightFreq[currentVal]--;
            
            if (targetVal <= 200000) {
                long leftCount = leftFreq[targetVal];
                long rightCount = rightFreq[targetVal];
                
                if (leftCount > 0 && rightCount > 0) {
                    totalTriplets = (totalTriplets + (leftCount * rightCount)) % MOD;
                }
            }
            
            leftFreq[currentVal]++;
        }
        
        return (int) totalTriplets;
    }
}