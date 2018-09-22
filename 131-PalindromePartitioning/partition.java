/*
Time complexity: O(n*(2^n))
For a string of length n, there will be (n - 1) intervals between chars.
For every interval, we can cut it or not cut it, so there will be 2^(n - 1) ways to partition the string.
For every partition way, we need to check if it is palindrome, which is O(n).
So the time complexity is O(n*(2^n))
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), res);
        return res;
    }
    
    private void backtrack(String s, int pos, ArrayList<String> sublist, List<List<String>> res) {
        if (pos == s.length())
            res.add(new ArrayList<String>(sublist));
        else
            for (int i = pos; i < s.length(); i++)
                if (isPalindrome(s, pos, i)) {
                    sublist.add(s.substring(pos, i + 1));
                    backtrack(s, i + 1, sublist, res);
                    sublist.remove(sublist.size() - 1);
                }         
    }
    
    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi)
            if (s.charAt(lo++) != s.charAt(hi--))
                return false;
        return true;
    }
}