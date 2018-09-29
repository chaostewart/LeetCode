// Greedy Algo. Time: O(n), Space: O(1)
class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        // lo, hi respectively represent the smallest and largest POSSIBLE number of open left brackets 
        for (char c: s.toCharArray()) {
            // If c is left bracket, then lo++, otherwise c must be or could be a right bracket, so lo--.
            lo += c == '(' ? 1 : -1;
            // If c is not a right bracket, then hi++, otherwise c must be a right bracket, so hi--.
            hi += c != ')' ? 1 : -1;
            // If hi < 0, too many right brackets
            if (hi < 0) return false;
            // lowest number of left brackets can never be less than 0
            lo = Math.max(lo, 0);
        }
        // check that we can have exactly 0 open left brackets.
        return lo == 0;
    }
}
