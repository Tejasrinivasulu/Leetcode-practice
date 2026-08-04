class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum =Integer.MIN_VALUE;
        int Sum = 0;

        for (int i = 0; i < nums.length; i++) {

            Sum += nums[i];

            if (Sum > maxSum) {
                maxSum = Sum;
            }

            if (Sum < 0) {
                Sum = 0;
            }
        }

        return maxSum;
    }
}