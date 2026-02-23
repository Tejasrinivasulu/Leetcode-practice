class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) return false;

        HashSet<String> set = new HashSet<>();
        int required = 1 << k; 

        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
            if (set.size() == required) return true;
        }

        return false;
    }
}