class Solution {
    public boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;
        while ( i < j) {
            // instead of removing punctuations and white spaces, skip them
            if (!Character.isLetterOrDigit(chs[i])) 
                i++;
            else if (!Character.isLetterOrDigit(chs[j])) 
                j--;
            else if (Character.toLowerCase(chs[i++]) != Character.toLowerCase(chs[j--]))
                return false;
        }
        return true;
    }
}