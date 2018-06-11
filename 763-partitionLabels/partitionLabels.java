class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastPos = new int[26];
        // traverse string S once to find index of last apprearance of a char
        for(int i = 0; i < S.length(); i++)
            lastPos[S.charAt(i) - 'a'] = i;
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;  //  start and end pointers for each substring
        // traverse S for the second time,
        for(int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastPos[S.charAt(i) - 'a']);   // update end if current char's end is further
            if (end == i) {  // if current char's end is itself, then current char is the end of substring
                res.add(i - start + 1);   
                start = end + 1;    // reset the start of the next substring
            }
        }
        return res;
    }
}