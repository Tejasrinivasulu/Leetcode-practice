class Solution {
    public int[] twoSum(int[] nums, int target) {
        int j = 0;
        while (j < nums.length) {
            for (int i = 0; i < (nums.length - 1); i++) {
             
                if (j!=i && (nums[j] + nums[i]) == target) {
                    return new int[] { j, i};
                }
                continue;
            }

            j++;
        }
        return null;
    }
}