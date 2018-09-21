class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int p : prices) {
            if (p < min)
                min = p;    // find "valleys"
            else if (p - min > res)
                res = p - min;   // calculate if the following peak - valley gives the max
        }
        return res;
    }
}
