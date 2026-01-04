class Solution {
    public int sumFourDivisors(int[] nums) {

        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int n = nums[i];
            int count = 0;
            int sum = 0;

            for (int j = 1; j * j <= n; j++) {
                if (n % j == 0) {
                    count++;
                    sum += j;

                    if (j != n / j) {
                        count++;
                        sum += n / j;
                    }
                }
            }

            if (count == 4) {
                totalSum += sum;
            }
        }

        return totalSum;
    }
}
