class Solution {
    public int[][] reconstructQueue(int[][] people) {
        /*
        Step 1. Pick out the tallest people, sort them by k in ascending order, save they in a list
           Each guy's index will be the same as his k value.
        Step 2. For the 2nd tallest people, insert each person into the list in step 1 by his k value. So on and so forth.
        E.g.
        input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        subarray after step 1: [[7,0], [7,1]]
        subarray after step 2: [[7,0], [6,1], [7,1]]
        */
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new LinkedList<>();
        for (int[] p : people)
            res.add(p[1], p);

        return res.toArray(new int[res.size()][]);
    }
}