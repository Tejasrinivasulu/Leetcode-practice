class Solution {
    public String reversePrefix(String s, int k) {
        String rev="";
        for(int i=k-1;i>=0;i--){
            rev=rev+s.charAt(i);
        }
        rev=rev+s.substring(k);
        return rev;
    }
}