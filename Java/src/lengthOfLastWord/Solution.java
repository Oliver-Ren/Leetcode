/** Status: Accepted. 
  * time complexity: O(n);
  * space compleity: O(1);
  * Status: Accepted.
  */

public class Solution {
    public int lengthOfLastWord(String s) {
        int ptr = s.length() - 1;
        int len = 0;

        for (; ptr >= 0 && (s.charAt(ptr) != ' ' && s.charAt(ptr) != '\t'); ptr--); 
        return s.length() - ptr - 1;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.print(test.lengthOfLastWord("dfsfd dfsd"));
    }
}
