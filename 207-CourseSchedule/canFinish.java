class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] numPrereq = new int[numCourses];  // count number of prerequisites for each course
        Map<Integer, List<Integer>> map = new HashMap<>();   // map<each prereq, list of courses requiring this prereq>
        
        for (int[] pair: prerequisites) {
            numPrereq[pair[0]]++;
            if (!map.containsKey(pair[1]))
                map.put(pair[1], new ArrayList<Integer>());
            map.get(pair[1]).add(pair[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numPrereq.length; i++)
            if (numPrereq[i] == 0)           // find course(s) without prereqs, push to queue
                queue.offer(i);
        
        int edgeCount = 0;      // count total number of edges in this topological graph
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if (map.containsKey(curr)) {
                edgeCount += map.get(curr).size();     // add num of outgoing edges to edgeCount 
                for (int ready: map.get(curr)) {
                    if(--numPrereq[ready] == 0)
                        queue.offer(ready);
                }
            }
        }
        
        return edgeCount == prerequisites.length;  // if a loop exists, edgeCount < prerequisites.length
}