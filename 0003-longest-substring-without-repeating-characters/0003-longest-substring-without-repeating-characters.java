import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        
        int left = 0; // left pointer of sliding window
        
        for (int right = 0; right < n; right++) {
            // if duplicate character found, remove from left side
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
