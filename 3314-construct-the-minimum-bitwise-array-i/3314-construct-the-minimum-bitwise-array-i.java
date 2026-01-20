class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int val = nums.get(i);

            // Even number → impossible
            if ((val & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            // Count trailing 1s
            int temp = val;
            int t = 0;
            while ((temp & 1) == 1) {
                t++;
                temp >>= 1;
            }

            // Remove highest bit among trailing ones
            ans[i] = val - (1 << (t - 1));
        }
        return ans;
    }
}
