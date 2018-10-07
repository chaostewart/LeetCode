// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {  
    private Iterator<Integer> iter;
    private Integer nextInt;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator;
        nextInt = iter.hasNext() ? iter.next() : null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextInt;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = nextInt;
        nextInt = iter.hasNext() ? iter.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return nextInt != null;
	}
}

/*
// A faster solution, don't understand yet..
class PeekingIterator implements Iterator<Integer> {
    
    private Integer nextInt;
    private Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        this.nextInt = null;   // nextInt only gets assigned with value in hasNext();
                                // nextInt gets re-assigned to null in next()
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (hasNext())
            return nextInt;
        return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (hasNext()) {
            Integer res = nextInt;
            nextInt = null;
            return res;
        }
        return null;
	}

	@Override
	public boolean hasNext() {
        if (nextInt != null)
            return true;
        
	    if (iterator.hasNext()) {
            nextInt = iterator.next();
            return true;
        }
        return false;
	}
}

*/