class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                int landEnd = landStartTime[i] + landDuration[i];
                int waterBegin = Math.max(landEnd, waterStartTime[j]);
                ans = Math.min(ans, waterBegin + waterDuration[j]);

                int waterEnd = waterStartTime[j] + waterDuration[j];
                int landBegin = Math.max(waterEnd, landStartTime[i]);
                ans = Math.min(ans, landBegin + landDuration[i]);
            }
        }

        return ans;
    }
}