import java.util.*;
/**
 * The BFS + DFS solution.
 * First using the BFS to build a DAG
 * from end to start containing valid
 * pathes, and then using DFS backtracking
 * to find all the pathes.
 *
 * Time complexity: O(k ^ n) where k is the radix, n is the length of the word.
 * Space complexity: O(k ^ n) for the BFS, the queue should contain so many
 * strings in the last level.
 * Status: Accepted, 229ms.
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        // precondition: beginWord, endWord and wordList are not null
        if (beginWord == null || endWord == null || wordList == null) {
            throw new NullPointerException();
        }

        // we should have a hash map to keep track of the lowest level
        // of any word in the graph, so that we could abandon pathes that
        // are longer than the shortest.
        Map<String, Integer> minLevel = new HashMap<String, Integer>();

        // The adjacent list for each word that we will construct. 
        Map<String, List<String>> neighbors = new HashMap<String, List<String>>();

        // Firstly, using the BFS to construct the graph.
        Queue<String> wordQueue = new LinkedList<String>();
        wordQueue.offer(beginWord);
        int currLevel = 1;

        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            for (int i = 0; i < size; i++) {
                String currWord = wordQueue.poll();
                for (String cand : enumCand(currWord)) {
                    // if not in dictionary, no need for add.
                    if (!wordList.contains(cand)) continue;
                    // the first time we meet this candidate word.
                    // we should set current level, and add a empty list
                    // for it as the adjacent list. And put the cand into
                    // the queue.
                    if (!minLevel.containsKey(cand)) {
                        minLevel.put(cand, currLevel + 1);
                        neighbors.put(cand, new ArrayList<String>());
                        wordQueue.offer(cand);
                    }
                    // avoid adding long paths to the new graph
                    if (currLevel + 1 <= minLevel.get(cand)) {
                        neighbors.get(cand).add(currWord);
                    }
                }
            }
            currLevel++;
        }
       
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        path.add(endWord);
        dfs(neighbors, path, result, endWord, beginWord);
        return result;

    }

    private List<String> enumCand(String word) {
        // precondition: word is not null
        char[] str = word.toCharArray();
        List<String> result = new ArrayList<String>();
        for (char k = 'a'; k <= 'z'; k++) {
            for (int i = 0; i < str.length; i++) {
                if (str[i] != k) {
                    char orig = str[i];
                    str[i] = k;
                    result.add(new String(str));
                    str[i] = orig;
                }
            }
        }

        return result;
    }

    private void dfs(Map<String, List<String>> neighbors, List<String> path,  
        List<List<String>> result, String curr, String target) {
        if (!neighbors.containsKey(curr)) return;
        if (curr.equals(target)) {
            List<String> cand = new ArrayList<String>(path);
            Collections.reverse(cand);
            result.add(cand);
            return;
        }
        
        for (String next : neighbors.get(curr)) {
            path.add(next);
            dfs(neighbors, path, result, next, target);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String beginWord = "hot";
        String endWord = "dog";
        Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("cog");
        wordList.add("dog");
        wordList.add("tot");
        wordList.add("hog");
        wordList.add("hop");
        wordList.add("pot");
        wordList.add("dot");
        List<List<String>> result =  s.findLadders(beginWord, endWord, wordList);
        for (List<String> l : result) {
            for (String str : l) {
                System.out.print(", " + str);
            }
            System.out.println();
        }
    }

}
