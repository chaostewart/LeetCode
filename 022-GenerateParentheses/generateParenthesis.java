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
        helper(res, new StringBuilder(), n, n);
        return res;
    }
    
    public void helper(List<String> res,StringBuilder sb,int open,int close) {
        if (open == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }
        if (open > 0) {
            sb.append("(");
            helper(res, sb, open - 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open < close) {
            sb.append(")");
            helper(res, sb, open, close - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}