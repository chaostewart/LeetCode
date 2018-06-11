class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> countMap = new HashMap<>();
        //String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");   // \s whitespace 
        String[] words = paragraph.replaceAll("\\p{P}", "").toLowerCase().split("\\s+");
        for(String w: words) {
            if (!banSet.contains(w))
                countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }
        return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}