class Solution {
    /*
    1. If sum of gas >= sum of cost, then there must be a solution. 
       And the question guaranteed that the solution is unique (the first one I found is the right one).
    2, The tank should never be negative, so restart whenever there is a negative number.
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        int start = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;    // if start == gas.length, then sumGas < sumCost, no solution
                tank = 0;    // reset tank
            }
        }
        if (sumGas < sumCost) 
            return -1;
        else 
            return start;
    }
}