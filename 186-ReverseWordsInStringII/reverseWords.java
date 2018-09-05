/*
Time complextiy is O(n). Here's the break down:
1. reverse the whole string, this is n steps.
2. advance right pointer to find end of word, the right pointer just advances through whole string and never backtracks, so this is n iterations.
3. reverse the word found, if word is length m, this is m steps, but consider all words together will be n, so this is also n steps total for all words.
*/
class Solution {
    public void reverseWords(char[] str) {
        reverseWords(str, 0, str.length - 1);   // reverse the whole string first
        for (int i = 0, j = 0; i <= str.length; i++) {   
            // then remove each individual word, set i <= str.length to include corner case
            if (i == str.length || str[i] == ' ') {   // same trick, check if i is out of boundary first
                reverseWords(str, j, i - 1); 
                j = i + 1;
            }
        }
    }
    
    private void reverseWords(char[] chars, int start, int end) {
        while(start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++; end--;
        }
    }
}
