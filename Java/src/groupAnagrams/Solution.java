import java.util.*;
/**
 * My first attempt for this problem.
 *
 * Time complexity: O(m * nlogn) where n is the length of word, m is number
 * of words.
 * Space complexity: O(m * n);
 * Status: Accepted
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>(); 
        for (String s : strs) {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            String cand = new String(str);
            if (!map.containsKey(cand)) {
                map.put(cand, new ArrayList<String>());
            }
            map.get(cand).add(s);
        }

        for (List l : map.values()) {
            Collections.sort(l);
        }

        List<List<String>> result = new ArrayList<List<String>>(map.values());
        return result;
            
    }

    public static void main(String[] args) {
        Solution test= new Solution();
        String[] aa = {"aab", "baa", "ccdd", "cdcd"};
        List<List<String>> result = test.groupAnagrams(aa);
        for (List<String> l : result) {
            for (String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    } 
}
