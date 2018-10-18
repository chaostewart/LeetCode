class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) 
                stack.pop();
            else if (!skip.contains(dir)) 
                stack.push(dir);
        }
        
        String res = "";
        while(!stack.isEmpty()) 
            res = "/" + stack.pop() + res;
        return res.isEmpty() ? "/" : res;
        
        /*
        // slightly faster when using the following linkedlist and stringbuilder
        String[] dirs = path.split("/");
        LinkedList<String> queue = new LinkedList<>();
        for (String dir: dirs) {
            if (dir.equals(".."))
                // where queue.pollLast() is equivalent to stack.pop()
                queue.pollLast();   // returns now if queue list empty instead of throwing an error
            else if (dir.equals(".") || dir.equals(""))
                continue;
            else
                queue.offer(dir);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            String dir = queue.poll();
            sb.append("/").append(dir);
        }
        return sb.length() == 0 ? "/" : sb.toString();
        */
        
    }
}
