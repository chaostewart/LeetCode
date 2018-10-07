class Solution {
    // Greedy algo.
    // recursive solution without stack, much faster
    public List<String> findItinerary(String[][] tickets) {     
        List<String> res = new LinkedList<>();
        if (tickets == null) return res;
        
        Map<String, Queue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0]))
                map.put(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }    
        
        search(res, "JFK", map);
        return res;
    }
    
    private void search(List<String> res, String from, Map<String, Queue<String>> map) {
        Queue<String> nexts = map.get(from);
        while (nexts != null && !nexts.isEmpty()) {
            String next = nexts.poll();
            search(res, next, map);
        } 
        res.add(0, from);
    }

 /*
    // slow iterative solution
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0]))
                map.put(ticket[0], new PriorityQueue());
            map.get(ticket[0]).add(ticket[1]);
        }

        List<String> route = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
                stack.push(map.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        
        return route;
    }
    */
}