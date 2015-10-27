import java.util.*;
/**
 * Revisit this problem.
 *
 * Time complexity: O(m * nlogn) where n is the length of word, m is number
 * of words.
 * Space complexity: O(m * n);
 * Status: Accepted
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // precondition: str is not null
        if (strs == null) {
            throw new NullPointerException();
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();

        for (String s : strs) {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            String sorted = new String(str);
            if (!anagramMap.containsKey(sorted)) {
                List<String> strList = new ArrayList<String>();
                anagramMap.put(sorted, strList);
                result.add(strList);
            }
            List<String> strList = anagramMap.get(sorted);
            strList.add(s); 
        }

        // Second round
        for (List l : result) {
            Collections.sort(l);
        }

        return result;

    }
} 
