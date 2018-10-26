class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            // strs[i].indexOf(pre) returns the index within strs[i] of the first occurrence of pre
            // or -1 if there is no such occurrence.
            while(strs[i].indexOf(pre) != 0) 
                pre = pre.substring(0, pre.length() - 1);

        return pre;
    }
}