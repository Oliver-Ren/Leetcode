/** 
 * Faster double ended bfs solution.
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // precondition:
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        Set<String> s1, s2;
       
        int level = 1;
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // swap
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            level++;
            
            Set<String> tempSet = new HashSet<String>();
            for (String curr : beginSet) {
                for (String neighbor : getNeighbors(curr, wordList)) {
                    if (endSet.contains(neighbor)) {
                        return level;
                    }
                    tempSet.add(neighbor);
                }
            }
            beginSet = tempSet;
        }
        
        return 0;
    }
    
    private List<String> getNeighbors(String curr, Set<String> wordList) {
        char[] str = curr.toCharArray();
        List<String> result = new ArrayList<String>();
        for (char k = 'a'; k <= 'z'; k++) {
            for (int i = 0; i < str.length; i++) {
                if (k != str[i]) {
                    char orig = str[i];
                    str[i] = k;
                    String cand = new String(str);
                    if (wordList.contains(cand)) {
                        result.add(cand);
                    }
                    str[i] = orig;
                }
            }
        }
        return result;
    }
}
