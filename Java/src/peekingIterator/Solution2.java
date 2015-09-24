// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
/**
 * This is my second solution for the problem.
 * I refered to the implementation of Google Guava
 * Peeking Iterator that avoids peeking unless necessary.
 * Status: Accepted.
 */

class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private boolean hasPeeked;
    private Integer peekValue;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        // Precondition: the passing iterator is not null.
        if (iterator != null) {
            this.iterator = iterator;
        } else {
            throw new NullPointerException();
        }
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
    // if the next eleement is null, that is OK, return null.
	public Integer peek() {
       if (!hasPeeked) {
           peekValue = iterator.next();
           hasPeeked = true;
       }

       return peekValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (!hasPeeked) {
            return iterator.next();
        }
        Integer result = peekValue;
        hasPeeked = false;
        peekValue = null;
        return result;
	}

	@Override
	public boolean hasNext() {
	    return (hasPeeked || iterator.hasNext()); 
	}
}
