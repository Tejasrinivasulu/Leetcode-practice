class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int cur=k;
        while(set.contains(cur)){
            cur=cur+k;
        }
        return cur;
    }
}