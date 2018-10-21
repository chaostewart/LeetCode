class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        /*
        int ans = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int diff = A[i + 1] - A[i];
            for (int j = i + 2; j < A.length; j++)
                if (A[j] - A[j - 1] == diff && j - i >= 2)
                    ans++;   
                else 
                    break;
        }
        return ans;
        */

        /*
        i) Need minimum 3 numbers for form an arithmetic sequence, so start at index 2
        ii) we get two same diffs, so we get an arith sequence ending at index i
        iii) At any index i, if a sequence is formed, it means a currently growing sequence gets extended upto index i, so curr++. Any time this happens, add the curr value to total count.
        iv) Any time we find no sequences can be formed at index i,reset curr to zero and grow a new sequence.
        */
        int curr = 0, count = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr++;
                count += curr;
            } else
                curr = 0;
        return count;
    }
}