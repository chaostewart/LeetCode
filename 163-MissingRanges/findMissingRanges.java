class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();

        // the next number we need to find
        int next = lower;

        for (int i = 0; i < nums.length; i++) {
            // not within the range yet
            if (nums[i] < next) continue;

            // continue to find the next one
            if (i == next) {
                if(i < Integer.MAX_VALUE) { 
                    next++;
                    continue;
                } else
                    return res;
            }

            // get the missing range string format
            res.add(getRange(next, nums[i] - 1));

            // now we need to find the next number
            if(i < Integer.MAX_VALUE)
                next = i + 1;
            else 
                return res;
        }

        // do a final check
        if (next <= upper) 
            res.add(getRange(next, upper));

        return res;
    }

    String getRange(int n1, int n2) {
      return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}