// Time: O(n), space: O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String seq = s.substring(i, i + 10);
            System.out.println(seq);
            if (!seen.add(seq))
                repeated.add(seq);
        }
        return new ArrayList(repeated);
    }
}