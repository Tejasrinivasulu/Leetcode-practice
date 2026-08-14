class Solution {
    public boolean search(int[] nums, int target) {
        boolean found=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                found=true;
                break;
            }
        }
        if(found){
            return true;
        }
        else{
            return false;
        }
    }
}