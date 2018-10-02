class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // start is the start of an interval
        int start = 0;
        for (String log : logs) {
            String[] lst = log.split(":");
            if (lst[1].equals("start")) {
                if (!s.isEmpty())
                    // lst[2] is the start of next interval, diffence b/w two start time is the interval time.
                    res[s.peek()] += Integer.parseInt(lst[2]) - start;
                s.push(Integer.parseInt(lst[0]));
                start = Integer.parseInt(lst[2]);
            } else {
                // lst[2] is the end of current interval, belong to current interval, so need to + 1 here.
                res[s.pop()] += Integer.parseInt(lst[2]) + 1 - start;
                // the start of next interval equals the end of current interval + 1
                start = Integer.parseInt(lst[2]) + 1;
            }
        }
        return res;
    }
}