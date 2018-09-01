class Solution {
    public int myAtoi(String str) {
        if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0;   // initialize sign, number base & index of str
        while(i < str.length() && str.charAt(i) == ' ' )     // always check i first for cases such as " "
            i++;
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {  // find sign
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        // if no digit after whitespace pr sign, reurn 0
        // if it's a digit, adding up the number
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            // Integer.MAX_VALUE = 2147483647
            // base > 214748364 OR base == 214748364 and the next digit is 8 or 9
            if (base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > Integer.MAX_VALUE%10))  
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;   // overflow case
            base = base * 10 + str.charAt(i) - '0';  
            i++;  // don't forget!
        }
        return sign * base;
    }
}
