class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int sum=0;
        int actualsum=0;
        sum = size*(size+1)/2;
        for(int i=0;i<size;i++){
           actualsum+=nums[i];
        }
        return sum-actualsum;
        
    }
}