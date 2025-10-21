import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Set<Integer> candidates = new HashSet<>();
        for (int num : nums) {
            candidates.add(num);
            candidates.add(num - k);
            candidates.add(num + k);
        }
        
        Arrays.sort(nums);
        
        int maxFrequency = 0;
        
        for (int target : candidates) {
            int firstTargetIdx = findFirstGreaterEqual(nums, target);
            int lastTargetIdx = findLastLessEqual(nums, target);
            
            int countFree = 0;
            if (firstTargetIdx <= lastTargetIdx && nums[firstTargetIdx] == target) {
                countFree = lastTargetIdx - firstTargetIdx + 1;
            }
            
            int firstInRangeIdx = findFirstGreaterEqual(nums, target - k);
            int lastInRangeIdx = findLastLessEqual(nums, target + k);
            
            int totalInRange = 0;
            if (firstInRangeIdx <= lastInRangeIdx) {
                totalInRange = lastInRangeIdx - firstInRangeIdx + 1;
            }
            
            int countCostly = totalInRange - countFree;
            int currentFrequency = countFree + Math.min(countCostly, numOperations);
            maxFrequency = Math.max(maxFrequency, currentFrequency);
        }
        
        return maxFrequency;
    }

    private int findFirstGreaterEqual(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int findLastLessEqual(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}