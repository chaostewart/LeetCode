class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] numPrereq = new int[numCourses];  // count number of prerequisites for each course
        Map<Integer, List<Integer>> map = new HashMap<>();   // map<each prereq, list of courses requiring this prereq>
        
        for (int[] pair: prerequisites) {
            numPrereq[pair[0]]++;
            if (!map.containsKey(pair[1]))
                map.put(pair[1], new ArrayList<Integer>());
            map.get(pair[1]).add(pair[0]);
        }
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numPrereq.length; i++)
            if (numPrereq[i] == 0)           // find course(s) without prereqs, push to queue
                queue.offer(i);
        
        int[] order = new int[numCourses];
        int i = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            order[i++] = curr;
            if (map.containsKey(curr)) 
                for (int ready: map.get(curr)) 
                    if(--numPrereq[ready] == 0)
                        queue.offer(ready);
            
        }
        
        return i == numCourses ? order : new int[0];            
    }
}