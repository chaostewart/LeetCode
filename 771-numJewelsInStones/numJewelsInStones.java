class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> Jset = new HashSet();    // add all chars in J to a set!
        for (char i: J.toCharArray()) {
            Jset.add(i);
        }
        int num = 0;
        for (char j: S.toCharArray()) {   // go through string S, check if each char is in the Jset
            if (Jset.contains(j)) {
                num++;
            }
        }
        return num;
    }
}