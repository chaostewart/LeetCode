// a much faster solution when using a constant size of int array
class Solution {
    public String reorganizeString(String S) {
        int[] freqs = new int[26];    
        for(char c: S.toCharArray()) {       // count the frequency of each char
            freqs[c-'a'] += 100;             // add 100 to freq for each apprearance
            if (freqs[c-'a']/100 > (S.length() + 1) / 2)
                return "";
        }
        
        for(int i = 0; i < freqs.length; i++) 
            freqs[i] += i;                   // add index to each value, to recover the index, simply do value % 100
        Arrays.sort(freqs);
        
        char[] chars = new char[S.length()]; 
        
        int index = 1;    // as the array freqs is sorted in ascending order, index has to set to 1 first, then restart at 0
        for(int freq: freqs){
            int realFreq = freq/100;
            char c = (char)('a' + (freq % 100));
            
            for(int i = 0; i < realFreq; i++) {
                if(index >= S.length()) index = 0;         // this condition will be true for only once!
                chars[index] = c;
                index += 2;                 // fill the array with current char at every other index
            }
        }
        return String.valueOf(chars);
    }
}


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
