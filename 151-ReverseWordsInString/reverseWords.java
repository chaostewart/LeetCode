public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chs = s.toCharArray();
        int len = cleanSpaces(chs);
        reverse(chs, 0, len - 1);
        int i = 0, j = 0;
        for (j = 0; j <= len; j++)
            if (j == len || chs[j] == ' ') {
                reverse(chs, i, j - 1);
                i = j + 1;
            }
        return new String(chs).substring(0, len);
    }
    
    private int cleanSpaces(char[] chs) {
        int len = chs.length;
        int i = 0, j = 0;
        while (j < len) {
            // skip leading spaces
            while (j < len && chs[j] == ' ') j++;
            // keep non spaces by copying/shifting them to the front 
            while (j < len && chs[j] != ' ')
                chs[i++] = chs[j++];
            // skip inbetween & tailing spaces
            while (j < len && chs[j] == ' ') j++;
            // if there are still chars left, put one space in between
            if (j < len)
                chs[i++] = ' ';
        }
        return i;
    }
    
    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            char c = chs[i];
            chs[i++] = chs[j];
            chs[j--] = c;
        }
    }
}
