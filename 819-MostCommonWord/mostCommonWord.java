class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> countMap = new HashMap<>();
        // \p{Punct}, Punctuation: One of !"#$%&'()*+,-./:;<=>?@[]^_`{|}~          
        // \s whitespace 
        String[] words = paragraph.replaceAll("\\p{Punct}", " ").toLowerCase().split("\\s+");
        for(String w: words) {
            if (!banSet.contains(w))
                countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }
        return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
