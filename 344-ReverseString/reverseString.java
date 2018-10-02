class Solution {
    public String reverseString(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char temp = chs[i];
            chs[i++] = chs[j];
            chs[j--] = temp;
        }
        return new String(chs);
    }
}