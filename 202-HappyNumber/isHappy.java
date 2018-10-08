class Solution {
    private int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            if(fast == 1) 
                return true;
        } while(slow != fast);
        return false;
        
        /*
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) return true;
            n = sum;
            sum = 0;
        }
        return false;  
        */
        
        /*
        if(n < 10) {
            if(n == 1||n == 7) 
                return true;
            else 
                return false;
         }
        int sum = 0;
        while(n > 0) {
              sum += (n % 10) * (n % 10);
              n /= 10;
        } 
        return isHappy(sum);
        */
    }
}