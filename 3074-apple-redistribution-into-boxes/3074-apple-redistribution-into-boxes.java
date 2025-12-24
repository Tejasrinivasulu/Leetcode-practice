class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        for(int i=0;i<apple.length;i++){
            sum=sum+apple[i];
        }
         Arrays.sort(capacity);
        int capsum=0;
        int count=0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            capsum=capsum+capacity[i];
            count++;
            if(capsum>=sum){
                return count;
            }
        }
        return count;
    }
}