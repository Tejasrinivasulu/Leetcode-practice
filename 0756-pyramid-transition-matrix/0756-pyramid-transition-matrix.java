import java.util.*;

class Solution {

    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        // Build mapping
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }

        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        // Base case: reached top
        if (bottom.length() == 1) return true;

        List<String> nextLevels = new ArrayList<>();
        buildNext(bottom, 0, new StringBuilder(), nextLevels);

        for (String next : nextLevels) {
            if (dfs(next)) return true;
        }
        return false;
    }

    private void buildNext(String bottom, int index,
                           StringBuilder curr, List<String> result) {

        if (index == bottom.length() - 1) {
            result.add(curr.toString());
            return;
        }

        String key = bottom.substring(index, index + 2);
        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            curr.append(c);
            buildNext(bottom, index + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1); 
        }
    }
}