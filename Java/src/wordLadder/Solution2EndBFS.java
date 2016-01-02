import java.util.*;
/**
 * Double-Ended BFS solution.
 * AS the begin and end are both known, we could use the 
 * double-ended BFS to accelerate.
 *
 * Time complexity: O(2^(n/2) * 2), where n is the length of the path.
 * Space complexity: O(2^(n/2) * 2) as the size is dominated by the
 * size of the bottom level.
 * Status: Accepted, 119ms.
 */
public class Solution2EndBFS {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // precondition: beginWord and endWord and wordList is not null.
        if (beginWord == null || endWord == null || wordList == null) {
            throw new NullPointerException();
        }

        Queue<String> topQueue = new LinkedList<String>();
        Queue<String> bottomQueue = new LinkedList<String>();
        Set<String> topMarked = new HashSet<String>();
        Set<String> bottomMarked = new HashSet<String>(); 

        int topLevel = 1;
        int bottomLevel = 1;
        topMarked.add(beginWord);
        topQueue.offer(beginWord);
        bottomMarked.add(endWord);
        bottomQueue.offer(endWord);

        while (!topQueue.isEmpty() && !bottomQueue.isEmpty()) {
            int topSize = topQueue.size();
            int bottomSize = bottomQueue.size();
            
            for (int i = 0; i < topSize; i++) {
                String curr = topQueue.poll();
                for (String transform : transform(curr)) {

                    if (!topMarked.contains(transform) 
                            && wordList.contains(transform)) {

                        if (bottomMarked.contains(transform)) {
                            return topLevel + bottomLevel;
                        }
                        topQueue.offer(transform);
                        topMarked.add(transform);
                    }
                }
            }
            topLevel++;

            for (int j = 0; j < bottomSize; j++) {
                String curr = bottomQueue.poll();
                for (String transform : transform(curr)) {

                    if (!bottomMarked.contains(transform) 
                            && wordList.contains(transform)) {

                        if (topMarked.contains(transform)) {
                            return topLevel + bottomLevel;
                        }
                        bottomQueue.offer(transform);
                        bottomMarked.add(transform);
                    }
                }
            }
            bottomLevel++;

        }

        return 0;

    }


    private List<String> transform(String word) {
        char[] str = word.toCharArray();
        List<String> result = new ArrayList<String>();
        for (char k = 'a'; k <= 'z'; k++) {
            for (int i = 0; i < str.length; i++) {
                if (k != str[i]) {
                    char orig = str[i];
                    str[i] = k;
                    result.add(new String(str));
                    str[i] = orig;
                }
            }
        }
        return result;
    }

}
