class Solution {
    // solved it using backtracking!! yay!
    public List<String> letterCombinations(String digits) {  
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(res, digits, new StringBuilder(), letters, 0);
        return res;
    }
    
    private void backtrack(List<String> res, String digits, StringBuilder sb, String[] letters, int start) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(start));
        int len = sb.length();
        for (char c : letters[digit].toCharArray()) {
            sb.append(c);
            backtrack(res, digits, sb, letters, start + 1);
            sb.setLength(len);
        }
    }
    /*
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();   // used as a queue here
        if (digits.isEmpty()) return res;
        // save mapping in a string list
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};  
        res.add("");   // this empty string is used in the for loop
        for (int i = 0; i < digits.length(); i++) {     // move along each integer in digits
            int x = Character.getNumericValue(digits.charAt(i));   // convert a char to an int
            while (res.peek().length() == i) {     // for strings of length i in the list, append another char to it
                String prefix = res.remove();      // .remove()  retreives and removes the first elem in the list   
                for (char c: mapping[x].toCharArray())   // find mapped characters of current integer x
                    res.add(prefix + c);   // append longer string to the end of the list
            }
        }
        return res;
       
    } 
    */
}
