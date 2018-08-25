class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);   // when a palindrome mirrors around a center letter
            int len2 = expandAroundCenter(s, i, i + 1); // when a palindrome mirrors around a center space between two letters
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;  // locating the start of the palindrome is tricky
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;   // Tricky here. when exiting the while loop L&R are "outside" of the palindrome
    }
}

/* A palindrome mirrors around its center. The center 
of a palindrome can be a letter or the space in between two letters.
Therefore, a palindrome can be expanded from its center, 
and there are only 2n - 1 such centers. 
Time complexity : O(n^2) Since expanding a palindrome around its center 
could take O(n) time.
Space complexity : O(n).
*/
