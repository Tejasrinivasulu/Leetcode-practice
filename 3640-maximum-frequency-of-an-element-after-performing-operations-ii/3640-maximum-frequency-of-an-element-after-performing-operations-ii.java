import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> count = new HashMap<>();
        TreeMap<Integer, Integer> line = new TreeMap<>();
        Set<Integer> candidates = new TreeSet<>();

        for (final int num : nums) {
            count.merge(num, 1, Integer::sum);
            
            line.merge(num - k, 1, Integer::sum);
            line.merge(num + k + 1, -1, Integer::sum);
            
            candidates.add(num);
            candidates.add(num - k);
            candidates.add(num + k + 1);
        }

        int ans = 1;
        int adjustable = 0;

        for (final int num : candidates) {
            adjustable += line.getOrDefault(num, 0);

            final int countNum = count.getOrDefault(num, 0);
            
            final int adjusted = adjustable - countNum;

            ans = Math.max(ans, countNum + Math.min(numOperations, adjusted));
        }

        return ans;
    }
}