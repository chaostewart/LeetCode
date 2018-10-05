class Solution {
    /*
    // passing string instead of stringbuilder to the backtrack function is slower, as everytime, it makes a copy of string
    // The idea here is to only add '(' and ')' that will guarantee a solution. 
    // Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. 

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    
    public void backtrack(List<String> res, String s, int open, int close, int max) {
        if (open == max && close == max) {
            res.add(s);
            return;
        }
        
        if (open < max) 
            backtrack(res, s + "(", open + 1, close, max);
        if (close < open)
            backtrack(res, s + ")", open, close + 1, max);
    }
    */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            backtrack(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            backtrack(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
