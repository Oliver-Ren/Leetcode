import java.util.Map;
import java.util.HashMap;
/**
 * As there are only 26 characters, we can
 * use one integer to encode the usage of the chars.
 * Use the hashmap to map certain maske to the maximum length.
 * Time Complexity: O(max(n^2, m * n)) where n is the number of words, 
 *                  m is the average length of the word.
 * Space Complexity: O(n);
 * Status: Accepted.
 */
public class Solution {
    public int maxProduct(String[] words) {
        // precondition: words is not null
        if (words == null) throw new NullPointerException();
       
        Map<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();
        int maxProd = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int mask = 0;
            for (int j = 0; j < word.length(); j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            
            int maxLen = word.length();
            if (lengthMap.containsKey(mask)) {
                maxLen = Math.max(maxLen, lengthMap.get(mask));
            }

            lengthMap.put(mask, maxLen);

            for (int mask2 : lengthMap.keySet()) {
                if ((mask & mask2) == 0) {
                    maxProd = Math.max(maxProd, lengthMap.get(mask) * lengthMap.get(mask2));
                }
            }
        }

        return maxProd;
    }
}
