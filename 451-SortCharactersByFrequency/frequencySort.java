class Solution {
    public String frequencySort(String s) {
        // this is an easy-level problem
        Map<Character, Integer> map = new HashMap<>();
        for (Character c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> sorted = new ArrayList<>(map.keySet());   
        Collections.sort(sorted, (a, b) -> map.get(b) - map.get(a));   // b-a gives descending order
        StringBuilder sb = new StringBuilder();      // first use of string builder
        for (char c: sorted) {
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);          // append()
                count--;
            }
        }
        return sb.toString();         // toString()   
    }
}