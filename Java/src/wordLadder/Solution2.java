import java.util.Arrays;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
import java.lang.StringBuilder;

/** 
 * My optimization of the previous BFS solution for word ladder.
 * If the word is found, termiate search immediately
 * without adding remaining cands to the queue.
 *
 * assume the length of the word is n.
 * Time complexity: O(26^n)
 * Space complexity: O(26^n) in the worst case.
 * Status: Accepted, 94ms.
 */

public class Solution2 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // Precondition: all the arguments should not be null
        if (beginWord == null || endWord == null || wordList == null) {
            throw new NullPointerException();
        }

        // the searching candidate for BFS.
        Queue<String> cands = new LinkedList<String>();
        // The number of levels (transformations)
        int level = 0;
        

        cands.offer(beginWord);
        while (!cands.isEmpty()) {
            int size = cands.size();
            level++;
            for (int i = 0; i < size; i++) {
                String currWord = cands.poll();
                char[] temp = currWord.toCharArray();
                for (char k = 'a'; k <= 'z'; k++) {
                    for (int j = 0; j < currWord.length(); j++) {
                        char original = temp[j];
                        if (original == k) continue;
                        temp[j] = k;
                        String cand = String.copyValueOf(temp); 
                        temp[j] = original;
                        if (wordList.contains(cand)) {
                            if (cand.equals(endWord)) {
                                return level + 1;
                            }
                            cands.offer(cand);
                            wordList.remove(cand);
                        }
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        Solution2 test = new Solution2();
        Set<String> set = new HashSet(Arrays.asList("hot","hog","dog"));
        
        System.out.println(test.ladderLength("hot", "dog", set));
    }

}


               


        
