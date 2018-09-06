class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res += countPalindrome(s, i, i);      //odd length
            res += countPalindrome(s, i, i + 1);  //even length
        }
        return res;
    }
        
    public int countPalindrome(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
    
}