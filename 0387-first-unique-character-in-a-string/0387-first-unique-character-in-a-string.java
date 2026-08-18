class Solution {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean repeated = false;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    repeated = true;
                    break;
                }
            }
            if (!repeated) {
                return i;
            }
        }
        return -1;
    }
}