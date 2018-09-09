class Solution {
    // Bellman ford on weighted directed graph
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        //run it k+1 iterations.
        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(prices, n);    // make a copy here due to num of stops restriction
            for (int[] flight : flights) {
                int curr = flight[0], next = flight[1], price = flight[2];
                if (prices[curr] == Integer.MAX_VALUE) continue;
                temp[next] = Math.min(temp[next], prices[curr] + price);
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}