class Solution {

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public boolean isGoodArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = gcd(result, nums[i]);
            if (result == 1) return true; 
        }
        return result == 1;
    }
}
