class Solution {
    public boolean rotateString(String A, String B) {
        // Time: O(n^2), space: O(n)
        return A.length() == B.length() && (A+A).contains(B);
    }
}
