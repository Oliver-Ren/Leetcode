package palindromePartitioning;
import java.util.ArrayList;
import java.util.List;

/** This is the dynamic programming approach for the
  * padlindrome partitioning problem.
  * From the leetcode discussion.
  * Time complexity is O(2^n), and space complexity is 
  * O(1). 
  * Status: Not Finished.
  */

public class SolutionDP {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            result[i + 1] = new ArrayList<List<String>>();
            char c = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                pair[i][j] = (s.charAt(j) == c && ((i - j < 2) || pair[i - 1][j + 1]));
                if (pair[i][j]) {
                    String str = s.substring(j, i + 1);
                    for (List<String> r : result[j]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i+1].add(ri);
                    }
                }
            }
        }

        return  result[len];
    }
}



