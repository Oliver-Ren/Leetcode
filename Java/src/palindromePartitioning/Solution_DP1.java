import java.util.*;

/* the bottom up DP solution.
 * Accepted, 442ms. */

public class Solution_DP1 {
    public List<List<String>> partitioning(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        
        // the cache, dp[i][j] stands for if string
        // element from i to j is a palindrome.
        boolean[][] dp = new boolean[len][len + 1];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j <= len; j++) {
                dp[i][j] = str[i] == str[j - 1] && (j - i < 3
                        || dp[i + 1][j - 1]);
            }
        }

        List<List<String>> [] sub_palin = new List[len];

        for (int i = len - 1; i >= 0; i--) {
            sub_palin[i] = new ArrayList<List<String>>();
            for (int j = i + 1; j <= len; j++) {
                if (dp[i][j]) {
                    System.out.println("i = " + i + "j = " + j);
                    String palindrome = new String(str, i, j - i);
                    if (j == len) {
                        List<String> newPath = new LinkedList<String>();
                        newPath.add(palindrome);
                        sub_palin[i].add(newPath);
                    } else {
                        for (List<String> l : sub_palin[j]) {
                            List<String> newList = new LinkedList<String>(l);
                            newList.add(0, palindrome);
                            sub_palin[i].add(newList);
                        }
                    }

                }
            }
        }

        return sub_palin[0];
    }

        
                    

    private boolean isPalindrome(char[] str, int start, int end) {
        end = end - 1;
        while (start < end && str[start++] == str[end--]);
        return start >= end;
    }
    
    public static void main(String[] args) {
        Solution_DP1 test = new Solution_DP1();
        List<List<String>> result = test.partitioning("aa");
        for (List<String> l : result) {
            for (String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }

}



