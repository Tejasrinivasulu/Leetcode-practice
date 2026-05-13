class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {

            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b);
            int high = Math.max(a, b);

            int sum = a + b;

            // Initially assume 2 moves for all sums
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            // 1 move range
            diff[low + 1] -= 1;
            diff[high + limit + 1] += 1;

            // 0 move at exact sum
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;
        int current = 0;

        for (int target = 2; target <= 2 * limit; target++) {
            current += diff[target];
            ans = Math.min(ans, current);
        }

        return ans;
    }
}