import java.lang.IllegalArgumentException;
/**
 * My first attempt of the problem.
 * Status: DNF;
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            throw new IllegalArgumentException("the input string should be non-empty");
        }

        if (s.isEmpty()) {
            return s;
        }

        char[] str = s.toCharArray();
        int start = 0;
        while (start < str.length && Character.isWhitespace(str[start])) start++;
        int end = str.length;
        while (end > start && Character.isWhitespace(str[end - 1])) end--;

        int i = start;
        int j = start;
        while (i < end) {
            while (j < end && !Character.isWhitespace(str[j])) {
                j++;
            }
            
            if (i < j) {
                reverse(str, i, j);
            }
            i = j + 1;
            while (i < end && Character.isWhitespace(str[i])) {
                i++;
            }
            j = i + 1;
        }
       
        reverse(str, start, end);
        return new String(str, start, end - start);
    }


    private void reverse(char[] str, int lo, int hi) {
        while (hi > lo + 1) {
            char temp = str[lo];
            str[lo] = str[hi - 1];
            str[hi - 1] = temp;
            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        String s = "    I love you      ";
        System.out.println(test.reverseWords(s));
    }
}
