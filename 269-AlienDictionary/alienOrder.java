class Solution {
    public String alienOrder(String[] words) {
        String res = "";
        if(words == null || words.length == 0) return res;
        
        Map<Character, Set<Character>> map = new HashMap<>();  // map<char i, set of chars after char i>
        Map<Character, Integer> degree = new HashMap<>();
        
        // build a degree map for each character in all the words
        for (String s: words)
            for (char c: s.toCharArray())
                degree.put(c, 0);
        /*
            w:0
            r:0
            t:0
            f:0
            e:0
        */
        
        // build the hashmap by comparing the adjacent words
        for (int i = 0; i < words.length - 1; i++){
            String curr = words[i];
            String next = words[i + 1];
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                // the first char that is different between two adjacent words reflects the lexicographical order
                if (c1 != c2) {
                    if (!map.containsKey(c1))
                        map.put(c1, new HashSet<Character>());
                    
                    if (!map.get(c1).contains(c2)) {
                        map.get(c1).add(c2);
                        degree.put(c2, degree.get(c2) + 1);    // increase the degree of c2
                    }
                    
                    break;
                }
            }
        }
        /*
        map:
            t -> set: f    
            w -> set: e
            r -> set: t
            e -> set: r
        degree:
            w:0
            r:1
            t:1
            f:1
            e:1
        */
        
        Queue<Character> q = new LinkedList<>();
        for (char c: degree.keySet())
            if (degree.get(c) == 0) 
                q.add(c);

        while(!q.isEmpty()){
            char c1 = q.poll();
            res += c1;
            if (map.containsKey(c1)) {     // map does not contain chars having no chars coming after them
                for (char c2: map.get(c1)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) 
                        q.add(c2);
                }
            }
        }
        
        return (res.length() != degree.size()) ? "" : res;
    }
}