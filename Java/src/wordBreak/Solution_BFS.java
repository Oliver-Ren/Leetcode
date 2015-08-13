import java.util.*;

/** The BFS solution with optimizaion
  * that the candidate length should 
  * not exceed the maximum length of
  * the words in the wordDict and should
  * also be greater than the minimum length;.
  *
  * time complexity: O(n ^ 2).
  * space complexity: O(n).
  * Status: Accepted, 244ms.
  */

public class Solution_BFS {
    private int[] minAndMaxLen(Set<String> wordDict) {
        int [] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = 0;

        for (String s : wordDict) {
            result[0] = Math.min(result[0], s.length());
            result[1] = Math.max(result[1], s.length());
        }

        return result;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null) {
            return false;
        }
       
        Queue<Integer> bfs = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();

        int[] minMax = minAndMaxLen(wordDict);

        bfs.offer(0);
        visited.add(0);

        while (!bfs.isEmpty()) {
            int curr = bfs.poll();
            for (int i = curr + minMax[0]; 
                    i <= curr + minMax[1] && i <= s.length(); i++) {
                if (visited.contains(i)) {
                    continue;
                }

                if (wordDict.contains(s.substring(curr, i))) {
                    if (i == s.length()) {
                        return true;
                    }
                    bfs.offer(i);
                    visited.add(i);
                }
            }
        }

        return false;
    }
}

