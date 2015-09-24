import java.util.Arrays;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;
import java.lang.StringBuilder;

/** 
 * My BFS solution for word ladder.
 * If the word is found, termiate search immediately
 * without adding remaining cands to the queue.
 *
 * assume the length of the word is n.
 * Time complexity: O(26^n)
 * Space complexity: O(26^n) in the worst case.
 * Status: Time Limit Exceeded.
 */

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // Precondition: all the arguments should not be null
        if (beginWord == null || endWord == null || wordList == null) {
            throw new NullPointerException();
        }

        wordList.add(endWord);
        // the set for keeping track of visited word.
        Set<String> visited = new HashSet<String>();
        // the searching candidate for BFS.
        Queue<String> cands = new LinkedList<String>();
        // The number of levels (transformations)
        int level = 0;
        // the flag for find and termiante.
        boolean isFound = false;
        

        cands.offer(beginWord);
        while (!cands.isEmpty() && !isFound) {
            int size = cands.size();
            level++;
            for (int i = 0; i < size && !isFound; i++) {
                String currWord = cands.poll();
                visited.add(currWord);
                StringBuilder sb = new StringBuilder(currWord);
                for (int j = 0; j < currWord.length() && !isFound; j++) {
                    char original = sb.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) {
                        sb.setCharAt(j, k);
                        String cand = sb.toString(); 
                        if (!visited.contains(cand) && wordList.contains(cand)) {
                            if (cand.equals(endWord)) {
                                isFound = true;
                                level++;
                                break;
                            }
                            cands.offer(cand);
                        }
                    }
                    // recover the original state
                    sb.setCharAt(j, original);
                }
            }
        }

        return isFound ? level : 0;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
        Set<String> set = new HashSet(Arrays.asList("hot","hog","dog"));
        
        System.out.println(test.ladderLength("hot", "dog", set));
    }

}


               


        
