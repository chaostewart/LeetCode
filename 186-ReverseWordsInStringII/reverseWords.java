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