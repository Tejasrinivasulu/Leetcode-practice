import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        int ops = 0;
        while (true) {
            boolean sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;
            int minSum = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                int s = list.get(i) + list.get(i + 1);
                if (s < minSum) {
                    minSum = s;
                    idx = i;
                }
            }
            list.set(idx, minSum);
            list.remove(idx + 1);
            ops++;
        }
        return ops;
    }
}