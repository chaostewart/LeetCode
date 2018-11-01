class Solution {
    // Bellman ford on weighted directed graph
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        //run it k+1 iterations.
        while(K-- >= 0) {
            int[] nextRound = Arrays.copyOf(prices, n);    // make a copy here due to num of stops restriction
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                if (prices[from] != Integer.MAX_VALUE)
                    nextRound[to] = Math.min(nextRound[to], prices[from] + price);
            }
            prices = nextRound;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
