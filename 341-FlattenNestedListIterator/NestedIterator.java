/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<ListIterator<NestedInteger>> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        /*
        A ListIterator has no current element; its cursor position always lies 
        between the element that would be returned by a call to previous() 
        and the element that would be returned by a call to next().
        */
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        //hasNext();
        // top iterator on a stack is always pointing to an int not a list
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            // the top list iterator on stack is pointing to NULL after a list is traversed, pop it
            if (!stack.peek().hasNext())
                stack.pop();
            else {
                // where x could be an integer, list or nestedList, the top iterator on stack has moved to the next!!
                NestedInteger x = stack.peek().next();
                // x is an integer
                if (x.isInteger())
                    // previous() returns the previous element in the list and moves the cursor position backwards.
                    // the following return line is a hack to combine stack.peek().previous() and return true.
                    return stack.peek().previous() == x;
                // x is a nested list
                stack.push(x.getList().listIterator());
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */