class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] a=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            int ans=-1;
            for(int j=0;j<nums.get(i);j++){
                if((j  | (j+1))==nums.get(i)){
                    ans=j;
                    break;
                }
            }
            a[i]=ans;
        }
        return a;
    }
}
