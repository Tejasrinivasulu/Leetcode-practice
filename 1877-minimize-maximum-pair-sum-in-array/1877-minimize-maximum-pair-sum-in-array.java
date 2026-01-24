import java.util.*;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int maxSum = 0;
        
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            maxSum = Math.max(maxSum, sum);
            left++;
            right--;
        }
        
        return maxSum;
    }
}