class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;
        char[] geneSet = new char[] {'A', 'C', 'G', 'T'};
        
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        beginSet.add(start);
        Set<String> endSet = new HashSet<>();
        endSet.add(end);
 
        int ans = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (endSet.size() < beginSet.size()) {
                // swap
                Set<String> temp = endSet;
                endSet = beginSet;
                beginSet = temp;
            }
            Set<String> newSet = new HashSet<>();
            for (String gene: beginSet) {
                //System.out.println(gene);
                char[] gchar = gene.toCharArray();
                for (int i = 0; i < 8; i++) {
                    char old = gchar[i];
                    for (char c : geneSet) {
                        gchar[i] = c;   
                        //String newGene = String.valueOf(gchar);
                        String newGene = new String(gchar);
                        //System.out.println(newGene);
                        if (endSet.contains(newGene))
                            return ans + 1;
                        if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                            visited.add(newGene);
                            newSet.add(newGene);
                        }
                    }
                    gchar[i] = old;
                }
            }
            beginSet = newSet;
            ans++;
        }
        return -1;       
    }
}