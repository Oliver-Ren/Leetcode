import java.util.Arrays;
import java.util.Comparator;
/**
 * As there are only 26 characters, we can
 * use one integer to encode the usage of the chars.
 * Time Complexity: O(max(n^2, m * n)) where n is the number of words, 
 *                  m is the average length of the word.
 * Space Complexity: O(n);
 * Status: Accepted.
 */
public class Solution {
    public int maxProduct(String[] words) {
        // precondition: words is not null
        if (words == null) throw new NullPointerException();
        
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() > b.length()) return -1;
                else if (a.length() < b.length()) return 1;
                return 0;
            }
        });      

        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= (1 << (c - 'a')); 
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() * words[i].length() < max) break;
            for (int j = i + 1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                    break;
                }
            }
        }
        
        return max;
    }
}
