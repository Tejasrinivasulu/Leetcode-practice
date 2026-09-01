class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, e = s.length() - 1;
        while (i < e) {
            if(!Character.isLetterOrDigit(s.charAt(i))) { 
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(e))) { 
                e--;
            }else if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(e))) { 
                i++;
                e--;
            }else { 
                return false;
            }
        }
        return true;
    }
}