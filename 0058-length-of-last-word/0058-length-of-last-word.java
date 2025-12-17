class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        String[] words=s.trim().split(" ");
        String result=words[words.length-1];
        return result.length();
    }
}