class Solution {
    public int reverseDegree(String s) {
        int total=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int reverse= 26 - (ch - 'a');
            total+=reverse*(i+1);
        }
        return total;
    }
}