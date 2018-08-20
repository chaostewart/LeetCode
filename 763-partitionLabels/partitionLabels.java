class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastPos = new int[26];
        // traverse string S once to find the position of last apprearance of each char
        for(int i = 0; i < S.length(); i++)
            lastPos[S.charAt(i) - 'a'] = i;
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;  //  create two pointers, start and end, to traverse S for the second time
        for(int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastPos[S.charAt(i) - 'a']);   // update end if current char's last appearance is further
            // if current char's last appearence is pointing itself, then current char is the end of substring
            if (end == i) { 
                res.add(i - start + 1);   
                start = end + 1;    // reset the start pointer for the next substring
            }
        }
        return res;
    }
}
