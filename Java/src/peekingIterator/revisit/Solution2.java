// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
/**
 * This is my second solution for the problem.
 * I refered to the implementation of Google Guava
 * Peeking Iterator that avoids peeking unless necessary.
 * Status: Accepted.
 */

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private boolean hasPeeked;
    private Integer peekedValue;

	public PeekingIterator(Iterator<Integer> iterator) {
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
            peekedValue = iterator.next();
            hasPeeked = true;
        }
        return peekedValue;
        
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (!hasPeeked) {
            return iterator.next();
        } else {
            hasPeeked = false;
            Integer result = peekedValue;
            peekedValue = null;
            return result;
        }
	}

	@Override
	public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
	}
}
