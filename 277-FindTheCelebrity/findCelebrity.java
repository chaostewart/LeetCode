/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
    int candidate = 0;
    /*
        The first loop will find the candidate. Suppose the candidate after the first for loop is person k, which means 0 to k-1 cannot be the celebrity, because they know a previous or current candidate. Also, since k knows no one between k+1 and n-1, k+1 to n-1 can not be the celebrity either. Therefore, k is the only possible celebrity, if there exists one.

    */
    for (int i = 1; i < n; i++) 
        if (knows(candidate, i))
            candidate = i;
    /*
        The second loop checks if k indeed 1) does not know any other persons between 0 to k-1 and 2) all other persons know k.
    */
    for (int i = 0; i < n; i++)
        if (!knows(i, candidate) || i < candidate && knows(candidate, i)) 
            return -1;
    
    return candidate;
    }
}