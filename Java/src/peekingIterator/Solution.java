// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html


/**
 * My first attempt of the problem.
 * The idea is to keep a value in the 
 * class which records the next value of 
 * the orignial iterator. which is similar
 * to a buffer.
 * Status: Accepted.
 */

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private boolean canPeek = false;
    private int nextVal = 0;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            canPeek = true;
            nextVal = this.iterator.next();
        }
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (canPeek) {
            return nextVal;
        }

        return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        int prevVal = nextVal;
        if (iterator.hasNext()) {
            canPeek = true;
            nextVal = iterator.next();
        } else {
            canPeek = false;
        }
        
        return prevVal;
	}

	@Override
	public boolean hasNext() {
       return canPeek; 
	    
	}
}
