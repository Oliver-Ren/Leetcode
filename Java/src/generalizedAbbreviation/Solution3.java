import java.util.List;
import java.util.ArrayList;
/**
 * Iterative bitmap incremental construction solution.
 * time complexity: O(2^n)
 * space complexity: O(2^n)
 * Status: Accepted.
 */
public class Solution3 {
    public List<String> generateAbbreviations(String word) {
        // precondition: word is not null
        if (word == null) {
            throw new NullPointerException();
        }

        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int len = word.length(); 
        int limit = 1 << len;
        for (int i = 0; i < limit; i++) {
            sb.setLength(0);
            int subset = i;
            int count = 0;
            for (int j = 0; j < len; j++) {
                int lsb2 = subset & 3;
                if ((lsb2 & 1) == 0) {
                    sb.append(word.charAt(j));
                } else {
                    if (lsb2 == 3) {
                        count++;
                    } else {
                        sb.append(Integer.toString(++count));
                        count = 0;
                    }
                }
                subset >>= 1;
            }
            result.add(sb.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        List<String> result = s.generateAbbreviations("ab");
        for (String str : result) {
            System.out.println(str);
        }
    }
        
            
}
       

