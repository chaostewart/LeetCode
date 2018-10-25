class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;    // corner cases
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true; notPrime[1] = true;   // for easy counting later
        
        for (int i = 2; i < n; i++)
            if (!notPrime[i])    // only update if current int is a prime
                for (int j = 2; i * j < n; j++)     
                    notPrime[i * j] = true;    // label more non prime ints
        
        int count = 0;
        for (boolean k: notPrime) 
            if (!k) 
                count++;
        return count;
    }
}
