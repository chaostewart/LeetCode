/*
For one step move left, we can figure out how points change with respect to the last position.
For each element, it must satisfy one of the three cases when moving from position i to position (i - 1 + n) % n:

No point get and no point lose, this happens when A[i] > i;
One point get, this happens when it moves from 0 to n - 1;
One point lost, this happens when A[i] == i and moves to i - 1.
*/

class Solution {
    public int bestRotation(int[] A) {
        int n = A.length;
        int change[] = new int[n];
        /*
        change[k] actually records all the LOST points after k steps moving left, by calculating how many elements would lose point at k.
        (i - A[i] + n) % n is the value of k making A[i]'s index just equal to A[i].
        Then if k is bigger when k = (i - A[i] + 1 + n) % n, we start to lose this point, making our score -= 1
        The relationship of turning point k and initial position of element i is: k = (i - A[i] + 1 + n) % n.
        So by looping i, we can calculate the vector of change[k].
        */
        for (int i = 0; i < n; ++i) 
            change[(i - A[i] + 1 + n) % n] -= 1;
        /*
        The second for loop actually calculates total changes in k step moving left via k - 1, so you could think of
        totalChange[k] = totalChange[k - 1] + change[k] + 1, as an equivalent as change[k] += change[k - 1] + 1.
        + 1 is the point obtained from moving index 0 to index n - 1.
        */
        int res = 0;
        for (int k = 1; k < n; ++k) {
            change[k] += change[k - 1] + 1;
            res = change[k] > change[res] ? k : res;
        }
        return res;
    }
}

/*
The above applies well when 0 < A[i] < A.length, but what if A[i] = 0 or A[i] = A.length()?
Their turning point k = (i - 0(or N) + 1 + N) % N = i + 1 is not real, because they never lose point! (0 always counts one point, and N never).
However, assume that 0(or N) is at position i in original array, and it needs i steps to move to position 0.
So when it arrives at the turning point i + 1, it is actually moving from 0 to A.length - 1,
which means we simultaneously subtract 1(in change[k]) and add 1 for totalChange[k].
*/