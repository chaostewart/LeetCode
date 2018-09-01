class Solution {
    public String reorganizeString(String S) {
        // Create map of each char to its count
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            // Impossible to form a solution
            if (map.get(c) > (S.length() + 1) / 2) 
                return "";
            
        }
        // Greedy: fetch char of max count as next char in the result.
        // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
        PriorityQueue<int[]> pq = new PriorityQueue<>(map.size(), (a, b) -> b[1] - a[1]);
        for (char c : map.keySet())
            pq.add(new int[] {c, map.get(c)});
        
        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) 
                    pq.add(first);
                
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) 
                    pq.add(second);           
                pq.add(first);
            }
        }
        return sb.toString();
    }
}