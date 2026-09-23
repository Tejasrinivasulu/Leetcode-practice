class Solution {
    public String reverseWords(String s) {
        String[] words=s.split(" ");
        String rev="";
        for(int i=0;i<words.length;i++){
            for(int j=words[i].length()-1;j>=0;j--){
                rev=rev+words[i].charAt(j);
            }
            rev=rev+" ";
        }
        return rev.trim();
    }
}