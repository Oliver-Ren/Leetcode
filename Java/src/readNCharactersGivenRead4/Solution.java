public class Solution {
    public int read(char[] buf, int n) {
        // precondition: buf is not null
        if (buf == null) throw new NullPointerException();

        int remaining = n;
        int readLen = 0;
        
        while (remaining > 4) {
            int len = read4(buf);
            // condition when buffer is not 
            // long enough
            if (len < 4) {
                return readLen + len;
            }

            readLen += 4;
            remaining -= 4;
        }

        // condition when remaining is no greater than 4
        int len = read4(buf);
        return readLen + len;
    }
}
