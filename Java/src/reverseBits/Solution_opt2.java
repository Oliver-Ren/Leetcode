import java.util.HashMap;
/* For the frequent function calls, we could
 * make use of the cache.
 * time complexity is O(log(sizeof(int)));
 * Space comlexity is O(1);
 * Status: Accepted, 340ms.
 */

public class Solution_opt2 {
    private final HashMap<Byte, Integer> cache = new HashMap<Byte, Integer>();
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        byte[] bytes = new byte[4];
        int temp = n;
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte)(temp & 0xFF);
            temp >>>= 8;
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result <<= 8;
            result += reverseByte(bytes[i]);
        }
        return result;
    }

    private int reverseByte(byte b) {
        Integer value = cache.get(b);
        if (value != null) {
            return value;
        } else {
            int reversed = 0;
            for (int i = 0; i < 8; i++) {
                reversed <<= 1;
                
                reversed |= ((b >>> i) & 1);
                
            }
            cache.put(b, reversed);
            return reversed;
        }
    }


    public static void main(String [] args) {
        
        Solution_opt2 test = new Solution_opt2();
        int a = test.reverseBits(1);

    }
}
